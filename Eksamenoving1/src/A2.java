public abstract class A2 {
    private String tekst;
    public A2(String tekst) {
        this.tekst = tekst;
    }

    public abstract void printTekst();
}

class B2 extends A2 {
    private String navn;

    public B2(String tekst, String navn){
        super(tekst);
        this.navn=navn;
    }

    @Override
    public void printTekst() {

    }
}
