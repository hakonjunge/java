package no.hiof.haakonju.zoo;

public class Elephant extends Animal{
    public Elephant(String name, int age) {
        super(name, DietType.HERBIVORE, age);
    }

    @Override
    public double calculateSpeed() {
        return 40 - (age * 0.8);
    }
}
