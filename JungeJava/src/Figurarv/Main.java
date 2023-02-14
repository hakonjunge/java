package Figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangelet = new Rektangel(4, 5, "Grønn");
        Sirkel sirkelen = new Sirkel(3, "Rød");

        System.out.println(sirkelen + " er " + sirkelen.getFarge());

        // Skriver ut en linje med * for å skille på utskriftene i terminalen
        System.out.println("\n*************Data i meter************");
        System.out.printf("%s sitt areal: %.2f og omkrets: %.2f%n", rektangelet, rektangelet.areal(), rektangelet.omkrets());
        System.out.printf("%s sitt areal i kvadratmeter: %.4f og omkrets i meter: %.2f%n", rektangelet, rektangelet.arealIMeter(), rektangelet.omkretsIMeter());

        System.out.println("\n\n****Figurtegning****");
        rektangelet.tegn();
        sirkelen.tegn();

        ArrayList<Figur> figurListe = new ArrayList<>();
        figurListe.add(sirkelen);
        figurListe.add(rektangelet);
        figurListe.add(new Rektangel(2,8,"Svart"));

        for (Figur figuren : figurListe){
            if (figuren instanceof Tegnbar){
                Tegnbar tegnBarFigur = (Tegnbar)figuren;
                System.out.println(tegnBarFigur.toString());
                tegnBarFigur.tegn();
            }
        }
    }
}