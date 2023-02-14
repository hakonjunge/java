package Losningsforslag;

import java.time.LocalDate;

public class Produksjon {
    private String tittel;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private String beskrivelse;

    public Produksjon(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.beskrivelse = beskrivelse;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}