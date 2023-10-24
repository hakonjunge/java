package pakke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Video extends Spillbar {
    private Lyd lyd;
    private BildeSekvens bildeSekvens;

    public Video(String navn, Lyd lyd, BildeSekvens bildeSekvens) {
        super(navn, Math.max(lyd.getVarighet(), bildeSekvens.getVarighet()));
        this.lyd = lyd;
        this.bildeSekvens = bildeSekvens;
    }

    public Lyd getLyd() {
        return lyd;
    }

    public BildeSekvens getBildeSekvens() {
        return bildeSekvens;
    }

    public void spill() {

    }

    public void sorterVideo() {
        List<Spillbar> spillbareObjekter = new ArrayList<>();
        Collections.sort(spillbareObjekter); // sorterer listen basert på navn
        for (Spillbar objekt : spillbareObjekter) {
            System.out.println(objekt.getNavn());
        }
    }

    @Override
    public String toString() {
        return "Video - " + getNavn() + ", varighet: " + getVarighet() + " sekunder";
    }

}
