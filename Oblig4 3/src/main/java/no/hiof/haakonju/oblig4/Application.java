package no.hiof.haakonju.oblig4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.haakonju.oblig4.controller.TvSerieController;
import no.hiof.haakonju.oblig4.controller.EpisodeController;
import no.hiof.haakonju.oblig4.repository.TvSerieDataRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {
       /* Javalin app = Javalin.create().start();

        app.get("/", new Handler() {
            @Override
            public void handle(Context ctx) {
                ctx.result("Hello World");

            }
        });*/

        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(8181);

        app.get("/", ctx -> ctx.result("Hello World!"));
        app.get("/tvserie", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));

        TvSerieDataRepository tvSerieRepository = new TvSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(tvSerieRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieRepository);


        app.get("/api/tvserie/{tvserie-id}", new Handler() {
            @Override
            public void handle(Context context) {
                tvSerieController.getAlleTvserier(context);
            }
        });

        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}", new Handler() {
            @Override
            public void handle(Context context) {
                episodeController.getAlleEpisoder(context);
            }
        });
        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {
            @Override
            public void handle(Context context) {
                episodeController.getEpisode(context);
            }
        });

    }
}
