package no.hiof.haakonju.zoo;

public class Main {
    public static void main(String[] args) {
        Zoo krsandDyrepark = new Zoo("Kristiansand Dyrepark");

        krsandDyrepark.addAnimalInZoo(new Lion("Simba", 3));
        krsandDyrepark.addAnimalInZoo(new Lion("Mufasa", 8));
        krsandDyrepark.addAnimalInZoo(new Elephant("Tantor", 21));
        krsandDyrepark.addAnimalInZoo(new Bird("Zazu", 37));

        krsandDyrepark.showAllAnimalsInfo();


    }
}