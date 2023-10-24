interface Kjekspakke{
    String farge = "Rød";
    String merke = "Ritz";

    void åpnet();
    void spistOpp();
}

public class EksempelkodeInterface implements Kjekspakke{
    public static void main(String args[]){
        System.out.println(farge);

        EksempelkodeInterface ex = new EksempelkodeInterface();
        ex.spistOpp();
        ex.åpnet();
    }
    @Override
    public void åpnet(){
        System.out.println("Kjekspakken er åpnet");
    }
    @Override
    public void spistOpp(){
        System.out.println("Kjekspakken er nesten spist opp");
    }
}
