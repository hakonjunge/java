package Losningsforslag;

import java.util.ArrayList;
import java.util.List;

public class Episode extends Produksjon {
    private int episodeNr, sesongNr;

    /**
     * Konstruktør for Episode
     * @param tittel - tittelen til episoden
     * @param episodeNr - episodenummeret til episoden (i denne sesongen)
     * @param sesongNr - sesongnummeret til episoden
     */

    /**
     * Konstruktør for Episode
     * @param episodeNr - episodenummeret til episoden (i denne sesongen)
     * @param sesongNr - sesongnummeret til episoden
     */

    public Episode(String tittel, int episodeNr, int sesongNr) {
        super(tittel, 0);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }
    public Episode(String tittel, int episodeNr, int sesongNr, int spilletid, Person regissor) {
        super(tittel, spilletid);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
        this.setRegissor(regissor);
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

    /**
     * Genererer en string for Episode
     * @return String i formen "NavnPåEpisode - S01E03 - Spilletid: 25"
     */

    @Override
    public String toString() {
        return getTittel() + " - S" + String.format("%02d", getSesongNr()) + "E" + String.format("%02d",
                getEpisodeNr()) + " - Spilletid: " + getSpilletid() + " - Regissør: " + getRegissor().toString();
    }

}
