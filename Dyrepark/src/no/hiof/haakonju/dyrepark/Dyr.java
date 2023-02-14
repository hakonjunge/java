package no.hiof.haakonju.dyrepark;

import java.time.LocalDate;

public abstract class Dyr implements Comparable<Dyr> {
    private String navn;
    private final int id;
    private LocalDate fodselsdag;

    @Override
    public int compareTo(Dyr dyret) {
        return navn.compareTo(dyret.getNavn());
    }

    public Dyr(String navn, LocalDate fodselsdag) {
        this.navn = navn;
        this.fodselsdag = fodselsdag;
        id = 1 + dyreTeller;
        dyreTeller++;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFodselsdag() {
        return fodselsdag;
    }

    public void setFodselsdag(LocalDate fodselsdag) {
        this.fodselsdag = fodselsdag;
    }

    private static int dyreTeller = 0;

    @Override
    public String toString() {
        return id + " - " + navn;
    }


}