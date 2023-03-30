package no.hiof.haakonju.oblig4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.haakonju.oblig4.controller.TvSerieController;
import no.hiof.haakonju.oblig4.controller.EpisodeController;
import no.hiof.haakonju.oblig4.model.TvSerie;
import no.hiof.haakonju.oblig4.repository.TvSerieCSVRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieDataRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieJSONRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(8100);


        app.before("/", ctx -> ctx.redirect("/tvserie"));

        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));
        app.get("/tvserie/{tvserieId}/sesong/{sesongNr}/episode/{episodeNr}/deleteepisode", new VueComponent(
                "episode-update"));

        String csvFilePath = "src/main/resources/tekstfiler/tvshows_10.csv";
        File csvFile = new File(csvFilePath);
        TvSerieCSVRepository tvSerieRepository = new TvSerieCSVRepository(csvFile);

        //TvSerieJSONRepository tvSerieJSONRepository = new TvSerieJSONRepository("/tekstfiler/tvshows_10.json");
        TvSerieCSVRepository tvSerieCSVRepository = new TvSerieCSVRepository(csvFile);
        TvSerieController tvSerieController = new TvSerieController(tvSerieCSVRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieCSVRepository);


        app.get("/api/tvserie", tvSerieController::getAlleTvSerier);


        app.get("api/tvserie/{tvserie-id}", context -> tvSerieController.getTVSerie(context));


        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}", episodeController::getEpisoderISesong);
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", episodeController::getEpisode);
        app.delete("/api/tvserie/{tvserieId}/sesong/{sesongNr}/episode/{episodeNr}/deleteepisode",
                episodeController::slettEpisode);

    }
}