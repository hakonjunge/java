package no.hiof.haakonju.oblig4.repository;

import java.util.List;

import no.hiof.haakonju.oblig4.data.Episode;
import no.hiof.haakonju.oblig4.data.TvSerie;
import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getAlleTvserier(String tittel);

    TvSerie getTvserie(String tittel, int antallsesonger);
    ArrayList<Episode> getAlleEpisoder(String tittel);
    Episode getEpisode(String tittel, int episodeNummer);
}
