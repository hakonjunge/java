package no.hiof.bebricen.oving4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.bebricen.oving4.controller.PlanetSystemController;
import no.hiof.bebricen.oving4.repository.UniverseCSVRepository;
import no.hiof.bebricen.oving4.repository.UniverseDataRepository;
import no.hiof.bebricen.oving4.repository.UniverseJSONRepository;
import org.jetbrains.annotations.NotNull;

import javax.xml.namespace.QName;

public class Application {

    public static void main(String[] args){

        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/planet-system"));


        app.get("/planet-system", new VueComponent("planet-system-overview"));
        app.get("/planet-system/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-system/:planet-system-id/planets/create", new VueComponent("planet-create"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));

        UniverseJSONRepository universeRepository = new UniverseJSONRepository("planets_100.json");
        UniverseCSVRepository universeCSVRepository = new UniverseCSVRepository("planets_100.json");
        Thread runnableJSONRepository = Thread.currentThread();
        PlanetSystemController universeController = new PlanetSystemController(universeRepository);

        app.get("/api/planet-system", universeController::getAllPlanetSystems);

        app.get("/api/planet-system/:planet-system-id", universeController::getPlanetSystem);

        app.get("/api/planet-system/:planet-system-id/planets", universeController::getAllPlanets);

        app.post("/api/planet-system/:planet-system-id/planets/create", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.createPlanet(ctx);
                String planetSystem = ctx.pathParam(":planet-system-id");
                ctx.redirect("/planet-system/" + planetSystem);
            }
        });

        app.get("/api/planet-system/:planet-system-id/planets/:planet-id", universeController::getPlanet);

        app.get("/api/planet-system/:planet-system-id/planets/:planet-id/delete", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.deletePlanet(ctx);
                String planetSystem = ctx.pathParam(":planet-system-id");
                ctx.redirect("/planet-system/" + planetSystem);
            }
        });

        app.post("/api/planet-system/:planet-system-id/planets/:planet-id/update", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.updatePlanet(ctx);
                String planetSystem = ctx.pathParam(":planet-system-id");
                ctx.redirect("/planet-system/" + planetSystem);
            }
        });

        // Optional moon API
        app.get("/api/planet-system/:planet-system-id/planets/:planet-id/moons", universeController::getMoons);

    }
}
