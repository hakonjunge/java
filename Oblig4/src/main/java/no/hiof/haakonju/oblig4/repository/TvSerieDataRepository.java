package no.hiof.haakonju.oblig4.repository;

import no.hiof.haakonju.oblig4.data.Episode;
import no.hiof.haakonju.oblig4.data.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerieDataRepository implements TvSerieRepository {
    private ArrayList<TvSerie> tvSerier = new ArrayList<>();
    private ArrayList<Episode> episoder = new ArrayList<>();


    public TvSerieDataRepository() {
        this.tvSerier = tvSerier;

        TvSerie strangerThings = new TvSerie("Stranger Things", "gutt forsvinner", LocalDate.of(2016,6,15));

        Episode e1s1 = new Episode("Chapter One: The Vanishing of Will Byers", 1, 1);
        Episode e2s1 = new Episode("Chapter Two: The Weirdo on Maple Street", 2, 1);
        Episode e3s1 = new Episode("Chapter Three: Holly Jolly", 3, 1);
        Episode e4s1 = new Episode("Chapter Four: The Body", 4, 1);

        // Legger til episodene i TVSerien
        strangerThings.leggTilEpisode(e1s1);
        strangerThings.leggTilEpisode(e2s1);
        strangerThings.leggTilEpisode(e3s1);
        strangerThings.leggTilEpisode(e4s1);

        tvSerier.add(strangerThings);

    }

    @Override
    public ArrayList<TvSerie> getAlleTvserier(String tittel) {
        for (TvSerie serie : tvSerier) {
            if (serie.getTittel().equals(tittel))
                return getAlleTvserier(tittel);
        }
        return new ArrayList<>();
    }

    @Override
    public TvSerie getTvserie(String tittel, int antallsesonger) {
        ArrayList<TvSerie> tvserien = getAlleTvserier(tittel);

        for (TvSerie tvserie : tvserien) {
            if (tvserie.getAntallSesonger() == antallsesonger)
                return tvserie;
        }
        return null;
    }

    @Override
    public ArrayList<Episode> getAlleEpisoder(String tittel) {
        for (Episode episode : episoder) {
            if (episode.getTittel().equals(tittel))
                return getAlleEpisoder(tittel);
        }
        return new ArrayList<>();
    }

    @Override
    public Episode getEpisode(String tittel, int episodeNummer) {
        ArrayList<Episode> episoden = getAlleEpisoder(tittel);

        for (Episode episode : episoder) {
            if (episode.getEpisodeNummer() == episodeNummer)
                return episode;
        }
        return null;
    }
}