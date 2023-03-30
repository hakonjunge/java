package no.hiof.haakonju.losningsforslag;

import controller.EpisodeController;
import controller.TvSerieController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import repository.TvSerieDataRepository;
import repository.TvSerieRepository;

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

        TvSerieRepository tvSerieRepository = new TvSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(tvSerieRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieRepository);

        app.get("api/tvserie", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                tvSerieController.getAlleTvSerier(ctx);
            }
        });

        app.get("api/tvserie/{tvserie-id}", context -> tvSerieController.getTVSerie(context));


        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}", episodeController::getEpisoderISesong);
        app.get("api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", episodeController::getEpisode);
    }
}
