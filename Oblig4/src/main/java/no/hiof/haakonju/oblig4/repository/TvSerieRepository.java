package no.hiof.haakonju.oblig4.repository;

import no.hiof.haakonju.oblig4.model.Episode;
import no.hiof.haakonju.oblig4.model.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getTVSerier();

    TvSerie getTvSerie(String tvSerieId);

    ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr);

    Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr);

    boolean leggTilTvSerie(TvSerie tvSerie);

    boolean oppdaterTvSerie(TvSerie tvSerie);

    boolean slettTvSerie(String tvSerieTittel);

    boolean leggTilEpisode(String tvSerieTittel, Episode episode);

    boolean oppdaterEpisode(String tvSerieTittel, int sesongNr, int episodeNr, Episode oppdatertEpisode);


    Episode createEpisode(String tvSerieTittel, int sesongNr, String episodeTittel, String beskrivelse, int episodeNummer,
                          int spilletid, LocalDate utgivelsesdato, String bildeurl);

    boolean oppdaterEpisode(String tvSerieTittel, int sesongNr, int episodeNr, String episodeTittel, String beskrivelse,
                            int spilletid, LocalDate utgivelsesdato, String bildeurl);
    void opprettEpisode(String tvSerieTittel, String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, String bildeUrl);

    void oppdaterEpisode(String tvSerieTittel, String tittel, int sesongNummer, int episodeNummer, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeUrl);

    boolean slettEpisode(String tittel, int episodeNr, int sesongNr);

    boolean updateEpisode(String tvSerieTittel, int sesongNr, int episodeNr, String episodeTittel, String beskrivelse,
                          int spilletid, LocalDate utgivelsesdato, String bildeurl);
}