package no.hiof.haakonju.zoo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void testCalculateSpeed() {
        Lion lion = new Lion("Simba", 5);
        double expectedSpeed = 52.5;
        double actualSpeed = lion.calculateSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Hastighetsberegningen for løven er feil.");
    }

    @Test
    public void testAnimalProperties() {
        String expectedName = "Simba";
        Animal.DietType expectedDietType = Animal.DietType.CARNIVORE;
        int expectedAge = 5;

        Lion lion = new Lion(expectedName, expectedAge);

        assertEquals(expectedName, lion.name, "Feil navn på løven.");
        assertEquals(expectedDietType, lion.dietType, "Feil diett-type for løven.");
        assertEquals(expectedAge, lion.age, "Feil alder på løven.");
    }

    @Test
    public void testAnimalToString() {
        Lion lion = new Lion("Simba", 5);
        String expectedString = "Simba, \ndietType: CARNIVORE, \nage: 5, \nspeed: 52.5km/h\n";
        String actualString = lion.toString();

        assertEquals(expectedString, actualString, "toString()-metoden returnerer feil informasjon.");
    }
}
