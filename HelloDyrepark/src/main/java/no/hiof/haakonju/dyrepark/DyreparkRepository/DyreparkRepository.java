package no.hiof.haakonju.dyrepark.DyreparkRepository;

import no.hiof.haakonju.dyrepark.dyrepark.Dyr;
import no.hiof.haakonju.dyrepark.dyrepark.Dyrepark;

import java.util.ArrayList;


public interface DyreparkRepository {
    ArrayList<Dyr> getDyrIDyrepark(String dyrepark);

    Dyr getDyr(String dyreparkNavn, int dyrId);
}
