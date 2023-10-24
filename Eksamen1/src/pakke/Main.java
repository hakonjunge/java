package pakke;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LydSamples lydSamples = new LydSamples();
        Lyd lyd = new Lyd("Sang", 180, 2, 44100, 16, lydSamples);
        System.out.println(lyd.toString());

        BildeSekvens bildeSekvens = new BildeSekvens("Eyo", List.of(1, 12, 13, 15, 16, 17, 18, 20, 21, 22, 24, 25, 26));
        Video video = new Video("Ferievideo", lyd, bildeSekvens);
        System.out.println(video.toString());


    }
}