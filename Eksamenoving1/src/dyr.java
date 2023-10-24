import java.util.ArrayList;
import java.util.List;

class Dyr {
    private static int id = 0;
    private String navn;
    private int aarOppdaget;
    private int populasjon;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Dyr.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Dyr(String navn, int aarOppdaget, int populasjon) {
        id = id + 1;
        this.navn = navn;
        this.aarOppdaget = aarOppdaget;
        this.populasjon = populasjon;
    }

    public String toString() {
        return "Navn: " + navn + " - Id: " + id;
    }

    public static void main(String[] args) {
        List<Dyr> dyreListe = new ArrayList<>();
        dyreListe.add(new Dyr("Europeisk Bison", 1758, 3200));
        dyreListe.add(new Dyr("Bongo", 1902, 28000));
        dyreListe.add(new Dyr("Fjellgaselle", 1766, 15000));
        for (Dyr etDyr : dyreListe)
            System.out.println(etDyr);
    }
}


