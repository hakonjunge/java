package pakke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Spillbar implements Comparable<Spillbar> {
    private String navn;
    private int varighet;

    public Spillbar(String navn, int varighet) {
        this.navn = navn;
        this.varighet = varighet;
    }

    public String getNavn() {
        return navn;
    }


    public int getVarighet() {
        return varighet;
    }





    @Override
    public int compareTo(Spillbar annen) {
        return navn.compareTo(annen.getNavn());
    }


    public abstract void spill();

    public abstract long getSize();

    public abstract boolean cdKvalitet();
}