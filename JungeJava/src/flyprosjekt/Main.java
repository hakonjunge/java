package flyprosjekt;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args)  {
        Fly airbusa380 = new Fly("Airbus-A380", 545);
        Fly boeing7478 = new Fly("Boeing 747-8", 467);
        Fly sr71 = new Fly("SR-71", 2);

        Fly[] flyArray = new Fly[4];

        flyArray[0] = airbusa380;
        flyArray[1] = boeing7478;
        flyArray[2] = sr71;
        flyArray[3] = new Fly("Boeing 737", 154);


        for (int i = 0; i < flyArray.length; i++)   {
            Fly etFly = flyArray[i];

            System.out.println("Det er " + etFly.getSeter() + " seter på flyet " + etFly.getModell());
            System.out.println();
        }
        ArrayList<Fly> flyArrayList = new ArrayList<>();

        flyArrayList.add(boeing7478);
        flyArrayList.add(sr71);
        flyArrayList.add(airbusa380);

        System.out.println("\nFly fra ArrayList:");
        for (int i = 0; i < flyArrayList.size(); i++) {

        }


        /*airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        airbusa380.leggTilEnPassasjer();
        System.out.println("Det er " + airbusa380.getSeter() + " seter på flyet " + airbusa380.getModell());*/
    }
}