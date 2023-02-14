package Losningsforslag;
import java.time.LocalDate;


public class Film extends Produksjon {
    public Film(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
    }
}
