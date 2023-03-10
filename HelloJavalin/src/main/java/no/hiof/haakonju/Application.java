package no.hiof.haakonju;

import io.import.Javalin;

import javax.naming.Context;
import java.util.logging.Handler;

public class Application {
    public static void main(String[] args){
        Javalin app = Javalin.create();
        app.start();

        app.get("/hello", new Handler()){
            @Override
            public void handle(Context context) {
                context.result("THISTLKDLHBLB");
            }
        }
    }
}
