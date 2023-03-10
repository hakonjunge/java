package Losningsforslag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// Lager og instansierer objektet strangerThings av typen TvSerie
        TvSerie strangerThings = new TvSerie("Stranger Things",
                "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.",
                LocalDate.of(2016, 7, 15));


        Person regissor1 = new Person("Peter", "Jackson");
        Person regissor2 = new Person("Matt", "Duffer");

        // Lager og instansierer noen objekter av typen Episode
        Episode episode1 = new Episode("Chapter One: The Vanishing of Will Byers", 1, 1, 50, regissor2);
        Episode episode2 = new Episode("Chapter Two: The Weirdo on Maple Street", 2, 1, 50, regissor2);
        Episode episode3 = new Episode("Chapter Three: Holly, Jolly", 3, 1, 50, regissor2);
        Episode episode4 = new Episode("Chapter Four: The Body", 4, 1, 50, regissor2);

        // Legger til episodeobjektene til tvserieobjektet strangerThings
        strangerThings.leggTilEpisode(episode1);
        strangerThings.leggTilEpisode(episode2);
        strangerThings.leggTilEpisode(episode3);
        strangerThings.leggTilEpisode(episode4);

        // Instansierer noen objekter av typen Episode og legger de direkte inn i TvSerie objektet strangerThings
        strangerThings.leggTilEpisode(new Episode("Chapter One: MADMAX", 1, 2, 50, regissor2));
        strangerThings.leggTilEpisode(new Episode("Chapter Two: Trick or Treat, Freak", 2, 2, 50, regissor2));
        strangerThings.leggTilEpisode(new Episode("Chapter Three: The Pollywog", 3, 2, 50, regissor2));

        // Henter ut en liste med episoder fra objektet strangerThings
        ArrayList<Episode> episodeListe = strangerThings.getEpisoder();

        System.out.println("**************************");
        System.out.println("* " + strangerThings + " *"); // Skriver ut TvSerie-objektet (toString() blir kalt)
        System.out.println("**************************");
        System.out.println("-------Alle Episoder------");

        // Går gjennom alle episoder og skriver ut objektet (toString blir kalt)
        for (Episode enEpisode : episodeListe) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************\n");

        // Lager og instansierer objektet gameOfThrones av typen TvSerie
        TvSerie gameOfThrones = new TvSerie("Game of Thrones", "They are in a game for the throne.", LocalDate.of(2011, 4, 11));

        // Oppretter og instansierer ett objekt av typen Random, for å kunne generere en tilfeldig spilletid
        Random randomTallGenerator = new Random();

        // En dobbel for-løkke som går gjennom å lager 5 sesonger med 20 episoder av Game of Thrones
        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {
                // Instansierer og legger til en episode, bruker Random-objektet til å generere et tall mellom 0 og 10, plusser så på 20 (for å få en verdi mellom 20 og 30)
                gameOfThrones.leggTilEpisode(new Episode("Generic Title", episodeNr, sesongNr, randomTallGenerator.nextInt(11) + 20, regissor2));
            }
        }

        // Henter ut alle episodene til TvSerie-objektet gameOfThrones for sesong 4
        ArrayList<Episode> gameOfThronesSesong4Episoder = gameOfThrones.hentEpisoderISesong(4);

        System.out.println("**************************");
        System.out.println("* " + gameOfThrones + " *");  // Skriver ut TvSerie-objektet (toString() blir kalt)
        System.out.println("**************************");
        System.out.println("**** Spilletid: " + gameOfThrones.getGjennomsnittligSpilletid() + "min ****");
        System.out.println("**************************");
        System.out.println("-------Episoder S04-------");

        // Går gjennom alle episoder vi hentet ut for sesong 4 og skriver ut Episode-objektet (toString blir kalt)
        for (Episode enEpisode : gameOfThronesSesong4Episoder) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************");

        // Prøver å legge til en episode i sesong 10 (om er flere nummer høyere enn nåværende antallet sesonger)
        gameOfThrones.leggTilEpisode(new Episode("EpisodeISesong10", 1, 10, 50, regissor2));
        System.out.println();
        System.out.println();
        System.out.println();







        Film lotrtfotr = new Film("The Lord of the Rings: The Fellowship of the Ring", 178, LocalDate.of(2001, 12,
                10), "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful " +
                "One Ring and save Middle-earth from the Dark Lord Sauron.", regissor1);
        Film lotrttt = new Film("The Lord of the Rings: The Two Towers", 179, LocalDate.of(2002, 12, 18), "While " +
                "Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes" +
                " a stand against Sauron's new ally, Saruman, and his hordes of Isengard.", regissor1);
        Film lotrrok = new Film("The Lord of the Rings: The Return of the King", 201, LocalDate.of(2003, 12, 17),
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam " +
                        "as they approach Mount Doom with the One Ring.", regissor1);

        System.out.println(lotrtfotr.getTittel() + " by " + regissor1.toString());
        System.out.println(lotrttt.getTittel() + " by " + regissor1.toString());
        System.out.println(lotrrok.getTittel() + " by " + regissor1.toString());


        Person skuespiller1 = new Person("Ian", "McKellen");
        Person skuespiller2 = new Person("Andy", "Serkis");
        Person skuespiller3 = new Person("Orlando", "Bloom");

        Rolle rolle1 = new Rolle("Skuespiller", "1", skuespiller1);
        Rolle rolle2 = new Rolle("Skuespiller", "2", skuespiller2);
        Rolle rolle3 = new Rolle("Skuespiller", "2", skuespiller3);

        Produksjon film = lotrrok;

        film.leggTilEnRolle(rolle1);

        ArrayList<Rolle> flereRoller = new ArrayList<Rolle>();
        flereRoller.add(rolle2);
        flereRoller.add(rolle3);
        film.leggTilMangeRoller(flereRoller);

        System.out.println("Roller i " + film.getTittel() + ":");
        for (Rolle rolle : film.getRoller()) {
            System.out.println(rolle.getRolleFornavn() + " " + rolle.getRolleEtternavn() + ": " + rolle.getSkuespiller().getFornavn() + " " + rolle.getSkuespiller().getEtternavn());
        }
        System.out.println(lotrtfotr.toString());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        Person millie = new Person("Millie Bobby", "Brown");
        Rolle eleven = new Rolle("Eleven", " ", millie);

        Person gaten = new Person("Gaten", "Matarazzo");
        Rolle dustin = new Rolle("Dustin", "Henderson", gaten);


        Produksjon serie = strangerThings;

        serie.leggTilEnRolle(eleven);
        List<Rolle> hellfire = new ArrayList<Rolle>();
        hellfire.add(dustin);
        hellfire.add(eleven);
        serie.leggTilMangeRoller((ArrayList<Rolle>) hellfire);



        List<Rolle> rollebesetning = strangerThings.getRollebesetning();
        for (Rolle rolle : rollebesetning) {
            System.out.println(rolle.toString() + " spilt av " + rolle.getSkuespiller().toString());
        }

    }

}