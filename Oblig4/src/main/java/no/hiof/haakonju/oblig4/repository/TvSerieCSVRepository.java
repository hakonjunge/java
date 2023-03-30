package no.hiof.haakonju.oblig4.repository;

import no.hiof.haakonju.oblig4.model.Episode;
import no.hiof.haakonju.oblig4.model.TvSerie;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class TvSerieCSVRepository implements TvSerieRepository {
    private File filnavn;
    private HashMap<String, TvSerie> tvSerieMap;

    public TvSerieCSVRepository(File file) {
        filnavn = file;
        tvSerieMap = new HashMap<>();
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(";");
                String tvSerieTittel = values[0];
                String beskrivelse = values[1];
                LocalDate utgivelsesdato = LocalDate.parse(values[2]);
                String bildeurl = values[3];
                String episodeTittel = values[4];
                String epBeskrivelse = values[5];
                int episodeNummer = Integer.parseInt(values[6]);
                int sesongNummer = Integer.parseInt(values[7]);
                int spilletid = Integer.parseInt(values[8]);
                LocalDate eputgivelsesdato = LocalDate.parse(values[9]);
                String epbildeurl = values[10];
                tvSerieMap.computeIfAbsent(tvSerieTittel, tittel -> new TvSerie(tvSerieTittel, beskrivelse, utgivelsesdato, bildeurl))
                        .leggTilEpisode(new Episode(episodeTittel, epBeskrivelse, episodeNummer, sesongNummer,
                                spilletid, eputgivelsesdato, epbildeurl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeEpisodeToCSV(BufferedWriter bw, TvSerie tvSerie, Episode episode) throws IOException {
        bw.write(String.format("%s,%d,%d,%d%n", tvSerie.getTittel(), episode.getSesongNummer(), episode.getEpisodeNummer(), episode.getSpilletid()));
    }
    private void writeToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filnavn))) {
            bw.write("TvSerieTittel,SesongNr,EpisodeNr,Spilletid\n");
            for (TvSerie tvSerie : tvSerieMap.values()) {
                for (Episode episode : tvSerie.getEpisoder()) {
                    writeEpisodeToCSV(bw, tvSerie, episode);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<TvSerie> getTVSerier() {
        if (tvSerieMap != null){
            return new ArrayList<>(tvSerieMap.values());
        }
        return new ArrayList<>();
    }

    @Override
    public TvSerie getTvSerie(String tvSerieTittel) {
        return tvSerieMap.get(tvSerieTittel);
    }

    @Override
    public ArrayList<Episode> getEpisoderISesong(String tvSerieTittel, int sesongNr) {
        TvSerie tvSerie = tvSerieMap.get(tvSerieTittel);
        return tvSerie != null ? tvSerie.hentEpisoderISesong(sesongNr) : null;
    }

    @Override
    public Episode getEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        return getTvSerie(tvSerieTittel).getEpisode(sesongNr, episodeNr);
    }

    @Override
    public boolean leggTilTvSerie(TvSerie tvSerie) {
        if (!tvSerieMap.containsKey(tvSerie.getTittel())) {
            tvSerieMap.put(tvSerie.getTittel(), tvSerie);
            writeToCSV();
            return true;
        }
        return false;
    }

    @Override
    public boolean leggTilEpisode(String tvSerieTittel, int sesongNr, Episode episode) {
        return false;
    }


    @Override
    public Episode createEpisode(String tvSerieTittel, int sesongNr, String episodeTittel, String beskrivelse, int episodeNummer,
                                 int spilletid, LocalDate utgivelsesdato, String bildeurl) {
        TvSerie tvSerie = tvSerieMap.get(tvSerieTittel);
        if (tvSerie != null) {
            Episode episode = new Episode(episodeTittel, beskrivelse, episodeNummer, sesongNr, spilletid, utgivelsesdato, bildeurl);
            tvSerie.leggTilEpisode(episode);
            writeToCSV();
            return episode;
        }
        return null;
    }

    @Override
    public boolean oppdaterEpisode(String tvSerieTittel, int sesongNr, int episodeNr, String episodeTittel, String beskrivelse,
                                   int spilletid, LocalDate utgivelsesdato, String bildeurl) {
        TvSerie tvSerie = tvSerieMap.get(tvSerieTittel);
        if (tvSerie != null) {
            Episode episode = tvSerie.getEpisode(sesongNr, episodeNr);
            if (episode != null) {
                episode.setTittel(episodeTittel);
                episode.setBeskrivelse(beskrivelse);
                episode.setSpilletid(spilletid);
                episode.setUtgivelsesdato(utgivelsesdato);
                episode.setBildeUrl(bildeurl);
                writeToCSV();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean oppdaterTvSerie(TvSerie tvSerie) {
        if (tvSerieMap.containsKey(tvSerie.getTittel())) {
            tvSerieMap.put(tvSerie.getTittel(), tvSerie);
            writeToCSV();
            return true;
        }
        return false;
    }

    @Override
    public boolean slettTvSerie(String tvSerieTittel) {
        if (tvSerieMap.containsKey(tvSerieTittel)) {
            tvSerieMap.remove(tvSerieTittel);
            writeToCSV();
            return true;
        }
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
    public boolean slettEpisode(String tvSerieTittel, int sesongNr, int episodeNr) {
        TvSerie tvSerie = tvSerieMap.get(tvSerieTittel);
        if (tvSerie != null) {
            boolean episodeSlettet = tvSerie.slettEpisode(sesongNr, episodeNr);
            if (episodeSlettet) {
                writeToCSV();
            }
            return episodeSlettet;
        }
        return false;
    }


}