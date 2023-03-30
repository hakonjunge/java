package no.hiof.bebricen.oving4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.bebricen.oving4.controller.PlanetSystemController;
import no.hiof.bebricen.oving4.repository.UniverseDataRepository;
import org.jetbrains.annotations.NotNull;

public class Application {

    public static void main(String[] args){
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/planet-system", new VueComponent("planet-system-overview"));
        app.get("/planet-system/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));

        UniverseDataRepository universeRepository = new UniverseDataRepository();
        PlanetSystemController universeController = new PlanetSystemController(universeRepository);

        app.get("/api/planet-system", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.getAllPlanetSystems(ctx);
            }
        });

        app.get("/api/planet-system/:planet-system-id", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.getPlanetSystem(ctx);
            }
        });

        app.get("/api/planet-system/:planet-system-id/planets", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.getAllPlanets(ctx);
            }
        });

        app.get("/api/planet-system/:planet-system-id/planets/:planet-id", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.getPlanet(ctx);
            }
        });

        // Optional moon API
        app.get("/api/planet-system/:planet-system-id/planets/:planet-id/moons", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                universeController.getMoons(ctx);
            }
        });

    }
}
