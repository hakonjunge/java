package no.hiof.haakonju.filskriving;

public class Superhero {
    private String name, alterEgo;

    public Superhero(String name, String alterEgo) {
        this.name = name;
        this.alterEgo = alterEgo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }
}
