package flyprosjekt;

public class Fly {
    private String modell;
    private int passasjerer;
    private int seter;

    public Fly(String modell, int seter)    {
        this.modell = modell;
        this.seter = seter;
        this.passasjerer = 0
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getPassasjerer() {
        return passasjerer;
    }

    public void setPassasjerer(int passasjerer) {
        this.passasjerer = passasjerer;
    }

    public int getSeter() {
        return seter;
    }

    public void setSeter(int seter) {
        this.seter = seter;
    }
}