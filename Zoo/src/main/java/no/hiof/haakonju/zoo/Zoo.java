package no.hiof.haakonju.zoo;

import java.util.ArrayList;

public class Zoo {

    private String navn;
    private ArrayList<Animal> animalList;

    public Zoo(String navn) {
        this.navn = navn;
        animalList = new ArrayList<>();
    }

    public void addAnimalInZoo(Animal animals) {
        animalList.add(animals);
    }

    public ArrayList<Animal> getAnimalList() {
        return new ArrayList<>(animalList);
    }
    public void showAllAnimalsInfo() {
        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }
}
