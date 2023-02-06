package Oblig_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class TVSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe;
    private double gjennomsnittligSpilletid;
    private int antallSesonger;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episodeListe = new ArrayList<Episode>();
        this.antallSesonger = 0;
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesong) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();
        for (Episode episode : episodeListe) {
            if (episode.getSesongNr() == sesong) {
                episoderISesong.add(episode);
            }
        }
        return episoderISesong;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {

        this.utgivelsesdato = utgivelsesdato;
    }

    public ArrayList<Episode> getEpisodeListe() {
        return episodeListe;
    }

    public void setEpisodeListe(ArrayList<Episode> episodeListe) {
        this.episodeListe = episodeListe;
    }

    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    public void setAntallSesonger(int antallSesonger) {
        this.antallSesonger = antallSesonger;
    }


    public void setGjennomsnittligSpilletid(double gjennomsnittligSpilletid) {
        this.gjennomsnittligSpilletid = gjennomsnittligSpilletid;
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int sum = 0;
        for (Episode episode : episodeListe) {
            sum += episode.getSpilletid();
        }
        gjennomsnittligSpilletid = sum / episodeListe.size();
    }

    public void leggTilEpisode(Episode episode) {
        episodeListe.add(episode);
        if (episode.getSesongNr() > this.antallSesonger) {
            this.antallSesonger = episode.getSesongNr();
        }
    }

    public void leggTilFlereEpisoder(ArrayList<Episode> episoder) {
        for (Episode episode : episoder) {
            if (!this.episodeListe.contains(episode)) {
                this.episodeListe.add(episode);
            }
        }
    }
}