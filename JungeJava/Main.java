package flyprosjekt;

public class Main{
    public static void main(String[] args)  {
        Fly airbusa380 = new Fly("Airbus-A380", 545);

        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();

        System.out.println("Det er " + airbusa380.getSeter() + " seter på flyet " + airbusa380.getModell());
    }
}