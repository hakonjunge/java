package no.hiof.haakonju.dyrepark;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        HonningGrevling honningGrevlingenNils = new HonningGrevling("Nils", LocalDate.of(2017, 6, 20));
        Panda pandaenTurid = new Panda("Turid", LocalDate.now(), "Hvit");
        Sjimpanse sjimpansenArne = new Sjimpanse("Arne", LocalDate.of(2020, 1, 2), 129);

        System.out.println(honningGrevlingenNils + " har spist " + honningGrevlingenNils.getAntallSlangerSpist());
        System.out.println(pandaenTurid + " har beltet " + pandaenTurid.getKungFuBelteFarge());
        System.out.println(sjimpansenArne + " har en iq på " + sjimpansenArne.getIq());

        Dyrepark kristiansandDyrepark = new Dyrepark("Kristiansand Dyrepark");

         kristiansandDyrepark.leggTilDyrIDyrepark(honningGrevlingenNils);
         kristiansandDyrepark.leggTilDyrIDyrepark(pandaenTurid);
         kristiansandDyrepark.leggTilDyrIDyrepark(sjimpansenArne);

         System.out.println("********Dyra i Dyreparken*********");
        System.out.println(kristiansandDyrepark.getDyreListe());

    }
}
