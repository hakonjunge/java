package no.hiof.haakonju.dyrepark;

import java.time.LocalDate;

public class HonningGrevling extends Dyr{
    public int antallSlangerSpist;

    public HonningGrevling(String navn, LocalDate fodselsdag) {
        super(navn, fodselsdag);
        antallSlangerSpist = 0;
    }

    public int getAntallSlangerSpist() {
        return antallSlangerSpist;
    }

    public void harSpistEnSlangeTil(){
        antallSlangerSpist++;
        if (antallSlangerSpist >= 5)
            System.out.println(getNavn()+ " må avlives! :'(");
    }
}
