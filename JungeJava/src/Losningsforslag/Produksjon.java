package Losningsforslag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produksjon {
    private String tittel;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private String beskrivelse;
    private Person regissor;
    private ArrayList<Rolle> roller;



    public Produksjon(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, Person regissor) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.beskrivelse = beskrivelse;
        this.regissor = regissor;
        this.roller = new ArrayList<Rolle>(); // Initialize the ArrayList


    }

    public Produksjon(String tittel, int spilletid) {
        this.tittel = tittel;
        this.spilletid = spilletid;
    }
    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
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

    public Produksjon(String tittel) {
        this.tittel = tittel;
        this.roller = new ArrayList<Rolle>();
    }



    public ArrayList<Rolle> getRoller() {
        return roller;
    }
    public void leggTilEnRolle(Rolle enRolle) {
        if (this.roller == null) {
            this.roller = new ArrayList<Rolle>();
        }
        this.roller.add(enRolle);
    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller) {
        if (this.roller == null) {
            this.roller = new ArrayList<Rolle>();
        }
        this.roller.addAll(flereRoller);
    }

    public List<Rolle> hentRollebesetning() {
        if (roller == null || roller.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(roller);
    }

}