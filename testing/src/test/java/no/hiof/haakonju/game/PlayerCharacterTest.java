package no.hiof.haakonju.game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharacterTest {
    private PlayerCharacter playerCharacter;

    @BeforeEach
    public void init(){
        playerCharacter = new PlayerCharacter();
    }
    @Test
    public void shouldDecreaseHealthAfterTakingDamage(){
        int initialHealth = 50;
        int damage = 10;

        playerCharacter.setHealth(initialHealth);
        playerCharacter.takeDamage(damage);

        assertEquals(40, playerCharacter.getHealth());
    }
    public void healthShouldMinimumBeZeroAfterDamage() {
        int initialHealth = 10;
        int damage = 20;

        playerCharacter.setHealth(initialHealth);
        playerCharacter.takeDamage(damage);

        assertEquals(0, playerCharacter.getHealth());
    }
}
