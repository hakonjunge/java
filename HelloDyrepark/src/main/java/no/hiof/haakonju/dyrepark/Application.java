package no.hiof.haakonju.dyrepark;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.haakonju.dyrepark.dyrepark.Dyr;
import no.hiof.haakonju.dyrepark.dyrepark.Panda;
import no.hiof.haakonju.dyrepark.dyrepark.Sjimpanse;
import no.hiof.haakonju.dyrepark.controller.DyreparkController;
import no.hiof.haakonju.dyrepark.DyreparkRepository.*;
import no.hiof.haakonju.dyrepark.controller.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(8181);

        app.get("/", new Handler() {
            @Override
            public void handle(Context context){
                context.redirect("/dyrepark/Kristiansand Dyrepark");
            }
        });

        app.get("/dyrepark/{dyrepark-id}", new VueComponent("dyrepark-detail"));
        app.get("/dyrepark/{dyrepark-id}/dyr/{dyr-id}", new VueComponent("dyr-detail"));


        DyreparkDataRepository dyreparkRepository = new DyreparkDataRepository();
        DyreparkController dyreparkController = new DyreparkController(dyreparkRepository);

        //http://localhost:8181/api/dyrepark/Kristiansand%20Dyrepark
        app.get("/api/dyrepark/{dyrepark-id}", new Handler() {
            @Overridec
            public void handle(Context context) {
                dyreparkController.getDyrIDyrepark(context);
            }
        });
        app.get("/api/dyrepark/{dyrepark-id}/dyr/{dyr-id}", new Handler() {
            @Override
            public void handle(Context context) {
                dyreparkController.getDyr(context);
            }
        });

    }
}