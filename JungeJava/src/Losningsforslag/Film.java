package Losningsforslag;

import java.time.LocalDate;


public class Film extends Produksjon {
    public Film(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, Person regissor) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse, regissor);
    }

    @Override
    public String toString() {
        return "Film: " + getTittel() + "Spilletid: " + getSpilletid() + " minutter  Utgivelsesdato: " + getUtgivelsesdato() + " Regissør: " + getRegissor().toString() + " Beskrivelse: " + getBeskrivelse();
    }
}
