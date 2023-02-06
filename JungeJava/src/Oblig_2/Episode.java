package Oblig_2;

import java.util.ArrayList;

public class Episode {
    private String tittel;
    private int episodeNr;
    private int sesongNr;
    private int spilletid;

    public Episode(String tittel, int episodeNr, int sesongNr, int spilletid) {
        this.tittel = tittel;
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
        this.spilletid = spilletid;
    }

    public Episode(String tittel, int episodeNr, int sesongNr) {
        this(tittel, episodeNr, sesongNr, 0);
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public int getSesongNr() {
        return sesongNr;
    }

    public void setSesongNr(int sesongNr) {
        this.sesongNr = sesongNr;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    @Override
    public String toString() {
        return "Episode: " + tittel + ", episode: " + episodeNr + ", sesong: " + sesongNr + ", spilletid: " + spilletid;
    }


}