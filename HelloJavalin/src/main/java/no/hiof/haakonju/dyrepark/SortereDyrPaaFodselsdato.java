package no.hiof.haakonju.dyrepark;

import java.util.Comparator;

public class SortereDyrPaaFodselsdato implements Comparator<Dyr> {
    @Override
    public int compare(Dyr dyr1, Dyr dyr2) {
        return dyr1.getFodselsdag().compareTo(dyr2.getFodselsdag());
    }
}
