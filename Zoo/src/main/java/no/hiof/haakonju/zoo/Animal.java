package no.hiof.haakonju.zoo;

public abstract class Animal {
    public enum DietType {
        HERBIVORE,
        CARNIVORE,
        OMNIVORE;
    }
    protected String name;
    protected DietType dietType;
    protected int age;

    public Animal(String name, DietType dietType, int age) {
        this.name = name;
        this.dietType = dietType;
        this.age = age;
    }

    public abstract double calculateSpeed();

    @Override
    public String toString() {
        return name + ", \ndietType: " + dietType + ", \nage: " + age + ", \nspeed: " + calculateSpeed() + "km/h\n";
    }
}