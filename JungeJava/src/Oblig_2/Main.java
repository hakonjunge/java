package Oblig_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        TVSerie serie1 = new TVSerie("The Office", "En dokumentarserie om hvordan livet i papir-firmaet Dunder Mifflin er", LocalDate.of(2005, 3, 24));

        Episode[] season1Episodes = {
                new Episode("Pilot", 1, 1, 22),
                new Episode("Diversity Day", 2, 1, 22),
                new Episode("Health Care", 3, 1, 22),
                new Episode("The Alliance", 4, 1, 22),
                new Episode("Basketball", 5, 1, 22),
                new Episode("Hot Girl", 6, 1, 22),
        };
        Episode[] season2Episodes = {
                new Episode("The Dundies", 1, 2, 22),
                new Episode("Sexual Harassment", 2, 2, 22),
                new Episode("Office Olympics", 3, 2, 22),
                new Episode("The Fire", 4, 2, 22),
                new Episode("Halloween", 5, 2, 22),
                new Episode("The Fight", 6, 2, 22),
                new Episode("The Client", 7, 2, 22),
                new Episode("Performance Review", 8, 2, 22),
                new Episode("Email Surveillance", 9, 2, 22),
                new Episode("Christmas Party", 10, 2, 22),
                new Episode("Boys and Girls", 11, 2, 22),
                new Episode("The Injury", 12, 2, 22),
                new Episode("The Secret", 13, 2, 22),
                new Episode("The Carpet", 14, 2, 22),
                new Episode("Boys and Girls", 15, 2, 22),
                new Episode("Valentine's Day", 16, 2, 22),
                new Episode("Dwight's Speech", 17, 2, 22),
                new Episode("Take Your Daughter to Work Day", 18, 2, 22),
                new Episode("Michael's Birthday", 19, 2, 22),
                new Episode("Drug Testing", 20, 2, 22),
                new Episode("Conflict Resolution", 21, 2, 22),
                new Episode("Casual Friday", 22, 2, 22),

        };
        Episode[] season3Episodes = {
                new Episode("Gay Witch Hunt", 1, 3, 22),
                new Episode("The Convention", 2, 3, 22),
                new Episode("The Coup", 3, 3, 22),
                new Episode("Grief Counseling", 4, 3, 22),
                new Episode("Initiation", 5, 3, 22),
                new Episode("Diwali", 6, 3, 22),
                new Episode("Branch Wars", 7, 3, 22),
                new Episode("Survivor Man", 8, 3, 22),
                new Episode("The Johannsen's", 9, 3, 22),
                new Episode("Andy's Play", 10, 3, 22),
                new Episode("Back from Vacation", 11, 3, 22),
                new Episode("Traveling Salesmen", 12, 3, 22),
                new Episode("The Return", 13, 3, 22),
                new Episode("Ben Franklin", 14, 3, 22),
                new Episode("Phyllis' Wedding", 15, 3, 22),
                new Episode("Business School", 16, 3, 22),
                new Episode("Cocktails", 17, 3, 22),
                new Episode("The Negotiation", 18, 3, 22),
                new Episode("Safety Training", 19, 3, 22),
                new Episode("Product Recall", 20, 3, 22),
                new Episode("Women's Appreciation", 21, 3, 22),
                new Episode("Beach Games", 22, 3, 22),
        };
        Episode[] season4Episodes = {
                new Episode("Fun Run", 1, 4, 22),
                new Episode("Dunder Mifflin Infinity", 2, 4, 22),
                new Episode("Launch Party", 3, 4, 22),
                new Episode("Money", 4, 4, 22),
                new Episode("Local Ad", 5, 4, 22),
                new Episode("Branch Wars", 6, 4, 22),
                new Episode("Survivor Man", 7, 4, 22),
                new Episode("The Deposition", 8, 4, 22),
                new Episode("Dinner Party", 9, 4, 22),
                new Episode("Chair Model", 10, 4, 22),
                new Episode("Night Out", 11, 4, 22),
                new Episode("Did I Stutter?", 12, 4, 22),
                new Episode("Job Fair", 13, 4, 22),
                new Episode("Goodbye, Toby", 14, 4, 22),
        };
        Episode[] season5Episodes = {
                new Episode("Weight Loss", 1, 5, 22),
                new Episode("Business Ethics", 2, 5, 22),
                new Episode("Baby Shower", 3, 5, 22),
                new Episode("Crime Aid", 4, 5, 22),
                new Episode("Employee Transfer", 5, 5, 22),
                new Episode("Customer Survey", 6, 5, 22),
                new Episode("Business Trip", 7, 5, 22),
                new Episode("Frame Toby", 8, 5, 22),
                new Episode("The Surplus", 9, 5, 22),
                new Episode("Moroccan Christmas", 10, 5, 22),
                new Episode("The Duel", 11, 5, 22),
                new Episode("Prince Family Paper", 12, 5, 22),
                new Episode("Stress Relief", 13, 5, 22),
                new Episode("Lecture Circuit (Part 1)", 14, 5, 22),
                new Episode("Lecture Circuit (Part 2)", 15, 5, 22),
                new Episode("Blood Drive", 16, 5, 22),
                new Episode("Golden Ticket", 17, 5, 22),
                new Episode("New Boss", 18, 5, 22),
                new Episode("Two Weeks", 19, 5, 22),
                new Episode("Dream Team", 20, 5, 22),
                new Episode("Michael Scott Paper Company", 21, 5, 22),
                new Episode("Heavy Competition", 22, 5, 22),
        };
        System.out.println("Tittel på TV-serien: " + serie1.getTittel());

        System.out.println();

        for (Episode episode : season5Episodes) {
            serie1.leggTilEpisode(episode);
        }

        for (Episode episode : serie1.getEpisodeListe()) {
            System.out.println("Tittel på episode: " + episode.toString());
        }

        System.out.println();
        System.out.println();

        System.out.println("Episodes in Season 5:");
        for (Episode episode : season5Episodes) {
            System.out.println(episode.getTittel());
        }


        System.out.println("Gjennomsnittlig spilletid for " + serie1.getTittel() + ": " + serie1.getGjennomsnittligSpilletid() + " minutter");
        ArrayList<Integer> episodeDurations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int episodeDuration = random.nextInt(11) + 20;
            episodeDurations.add(episodeDuration);
        }

        int totalDuration = 0;
        for (int duration : episodeDurations) {
            totalDuration += duration;
        }

        double averageDuration = (double) totalDuration / episodeDurations.size();
        System.out.println("Gjennomsnittlig spilletid: " + averageDuration);

    }

}
