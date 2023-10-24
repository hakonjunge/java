package no.hiof.haakonju.oblig4.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.haakonju.oblig4.model.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TvSerieJSONRepository implements TvSerieRepository {
    private List<TvSerie> tvSeries;
    private String fileName;

    public String getfileName() {
        return fileName;
    }

    public void setfileName(String fileName) {
        this.fileName = fileName;
    }

    public TvSerieJSONRepository(String fileName) {
        tvSeries = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            tvSeries = objectMapper.readValue(bufferedReader, new TypeReference<List<TvSerie>>() {
            });
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TvSerieJSONRepository(File file) {
        this(file.getPath());
    }

    public List<TvSerie> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TvSerie> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public void reload() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getfileName()));
            tvSeries = objectMapper.readValue(bufferedReader, new TypeReference<List<TvSerie>>() {
            });
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void skrivTilFil(String filnavn, List<TvSerie> tvSeries) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filnavn), this.tvSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<TvSerie> getTVSerier() {
        return null;
    }

    @Override
    public TvSerie getTvSerie(String tvSerieId) {
        return null;
    }

    @Override
    public ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr) {
        return null;
    }

    @Override
    public Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        return null;
    }

    @Override
    public boolean leggTilTvSerie(TvSerie tvSerie) {
        return false;
    }

    @Override
    public boolean oppdaterTvSerie(TvSerie tvSerie) {
        return false;
    }

    @Override
    public boolean slettTvSerie(String tvSerieTittel) {
        return false;
    }

    @Override
    public boolean leggTilEpisode(String tvSerieTittel, Episode episode) {
        return false;
    }

    @Override
    public boolean oppdaterEpisode(String tvSerieTittel, int sesongNr, int episodeNr, Episode oppdatertEpisode) {
        return false;
    }


    @Override
    public Episode createEpisode(String tvSerieTittel, int sesongNr, String episodeTittel, String beskrivelse, int episodeNummer, int spilletid, LocalDate utgivelsesdato, String bildeurl) {
        return null;
    }

    @Override
    public boolean oppdaterEpisode(String tvSerieTittel, int sesongNr, int episodeNr, String episodeTittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeurl) {
        return false;
    }

    @Override
    public void opprettEpisode(String tvSerieTittel, String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, String bildeUrl) {

    }

    @Override
    public void oppdaterEpisode(String tvSerieTittel, String tittel, int sesongNummer, int episodeNummer, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeUrl) {

    }

    @Override
    public boolean slettEpisode(String tittel, int episodeNr, int sesongNr) {
        return false;
    }

    @Override
    public boolean updateEpisode(String tvSerieTittel, int sesongNr, int episodeNr, String episodeTittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, String bildeurl) {
        return false;
    }

}