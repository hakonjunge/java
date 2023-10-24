package no.hiof.haakonju.zoo;

public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, DietType.OMNIVORE, age);
    }

    @Override
    public double calculateSpeed() {
        return 60 - (age * 0.5);
    }
}

