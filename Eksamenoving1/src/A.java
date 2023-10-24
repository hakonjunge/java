public class A {
    private static String NAVN = "superduperklasse";

    public A(String navn)   {
        this.NAVN = navn;
    }
}

class B extends A{
    private int verdi;

    public B(String navn, int verdi){
        super(navn);
        this.verdi = verdi;
    }
}
