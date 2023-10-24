package pakke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lyd extends Spillbar{
    private int kanaler;
    private int samplingsrate;
    private int bitPerLagring;
    private LydSamples lydSamples;

    public Lyd(String navn, int varighet, int kanaler, int samplingsrate, int bitPerLagring, LydSamples lydSamples) {
        super(navn, varighet);
        if (kanaler < 1 || kanaler > 24) {
            throw new IllegalArgumentException("Ugyldig antall kanaler: " + kanaler);
        }
        this.kanaler = kanaler;
        this.samplingsrate = samplingsrate;
        this.bitPerLagring = bitPerLagring;
        this.lydSamples = lydSamples;
    }



    public int getKanaler() {
        return kanaler;
    }

    public int getSamplingsrate() {
        return samplingsrate;
    }

    public int getBitPerLagring() {
        return bitPerLagring;
    }

    public LydSamples getLydSamples() {
        return lydSamples;
    }

    @Override
    public void spill() {

    }

    @Override
    public long getSize() {
        int bytesPerSample = (bitPerLagring + 7) / 8;
        int antallBytes = kanaler * samplingsrate * bytesPerSample * getVarighet();
        return antallBytes;
    }


    @Override
    public boolean cdKvalitet() {
        boolean minstToKanaler = kanaler >= 2;
        boolean minst44100Hz = samplingsrate >= 44100;
        boolean minst16Bits = bitPerLagring >= 16;

        return minstToKanaler && minst44100Hz && minst16Bits;
    }

    public void sorterLyd() {
        List<Spillbar> spillbareObjekter = new ArrayList<>();
        Collections.sort(spillbareObjekter); // sorterer listen basert på navn
        for (Spillbar objekt : spillbareObjekter) {
            System.out.println(objekt.getNavn());
        }
    }
    @Override
    public String toString() {
        return "Lyd - " + getNavn() + ", varighet: " + getVarighet() + " sekunder";
    }

}
