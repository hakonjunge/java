package Losningsforslag;
import java.time.LocalDate;
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

    public Episode(String tittel, int episodeNr, int sesongNr, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, 0, utgivelsesdato, beskrivelse);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }
    public Episode(String tittel, int episodeNr, int sesongNr, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
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
        return getTittel() + " - S" + String.format("%02d", getSesongNr()) + "E" + String.format("%02d", getEpisodeNr()) + " - Spilletid: " + getSpilletid();
    }
}
