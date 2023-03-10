package no.hiof.haakonju.dyrepark.dyrepark;

import java.util.ArrayList;

public class Dyrepark {
    private String navn;
    private ArrayList<Dyr> dyreListe;

    public Dyrepark(String navn) {
        this.navn = navn;
        dyreListe = new ArrayList<>();
    }

    public void leggTilDyrIDyrepark(Dyr dyret) {
        dyreListe.add(dyret);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Dyr> getDyreListe() {
        return new ArrayList<>(dyreListe);
    }
}
