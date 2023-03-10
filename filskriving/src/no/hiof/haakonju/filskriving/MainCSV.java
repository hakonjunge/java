package no.hiof.haakonju.filskriving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainCSV {
    public static void main(String[] args){
        Superhero batman = new Superhero("Batman", "Bruce Wayne");
        Superhero wonderWoman = new Superhero("Wonder Woman", "Diana Prince");

        List<Superhero> superheroList = new ArrayList<>();

        superheroList.add(batman);
        superheroList.add(wonderWoman);

        writeToCSVFile(superheroList, "superheroes.csv");
    }

    private static void writeToCSVFile(List<Superhero> superheroList, String filepath){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))){
            for(Superhero superhero : superheroList){
                bufferedWriter.write(superhero.getName() + ";" + superhero.getAlterEgo());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
