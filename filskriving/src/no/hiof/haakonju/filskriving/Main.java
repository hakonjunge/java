package no.hiof.haakonju.filskriving;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filsti = "novelle.txt";

        String lestTekst = "";

        System.out.println("Skriv tekst ('avslutt' for å avslutte)");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(filsti, true)){
            while (!lestTekst.equals("avslutt")){

                lestTekst = bufferedReader.readLine();

                fileWriter.write(lestTekst + "\n");
            }

        } catch (IOException ioException) {

            System.err.println(ioException.getMessage());

        } finally {
            System.out.println("Kjøres uansett om en feil skjer eller ikke");

        }
    }
}