package no.hiof.haakonju.zoo;

public class Lion extends Animal{
    public Lion(String name, int age) {
        super(name, DietType.CARNIVORE, age);
    }

    @Override
    public double calculateSpeed() {
        return 60 - (age * 1.5);
    }
}
