package no.hiof.haakonju.dyrepark.controller;

import io.javalin.http.Context;
import no.hiof.haakonju.dyrepark.DyreparkRepository.DyreparkRepository;
import no.hiof.haakonju.dyrepark.dyrepark.Dyr;

import java.util.ArrayList;

public class DyreparkController {
    private DyreparkRepository dyreparkRepository;

    public DyreparkController(DyreparkRepository dyreparkRepository) {
        this.dyreparkRepository = dyreparkRepository;
    }
    public void getDyrIDyrepark(Context context)    {
        String dyreparkNavn = context.pathParam("dyrepark-id");

        ArrayList<Dyr> dyrIDyrepark = dyreparkRepository.getDyrIDyrepark(dyreparkNavn);

        context.json(dyrIDyrepark);
    }

    public void getDyr(Context context) {
        String dyreparkNavn = context.pathParam("dyrepark-id");
        int dyrId = Integer.parseInt(context.pathParam("dyr-id"));

        Dyr dyr = dyreparkRepository.getDyr(dyreparkNavn, dyrId);

        context.json(dyr);
    }
}
