package se.abdilhakim.adventure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import se.abdilhakim.adventure.model.Burglar;
import se.abdilhakim.adventure.model.Resident;

import static org.junit.jupiter.api.Assertions.*;

public class PunchTest {

    private Resident resident;
    private Burglar burglar;

    @BeforeEach
    void setUp() {
        resident = new Resident();
        burglar = new Burglar();
    }

    @Test
    void testPunchDecreasesHealth() {
        int initialBurglarHealth = burglar.getHealth();

        resident.punch(burglar);

        assertEquals(initialBurglarHealth - resident.getDamage(), burglar.getHealth(),
                "Burglar's health should decrease by Resident's damage.");
    }

    @Test
    void testTakeHitDecreasesHealth() {
        int initialHealth = burglar.getHealth();
        int damage = 4;  // Sätt en skada att ta emot.

        burglar.takeHit(damage);  // Burglar tar skada.

        assertEquals(initialHealth - damage, burglar.getHealth(),
                "Burglar's health should decrease by the amount of damage taken.");
    }

    @Test
    void testIsConsciousWhenAlive() {
        // Kontrollera att en levande tjuv är medveten.
        assertTrue(burglar.isConscious(), "Burglar should be conscious when health is above 0.");

    }

    @Test
    void testIsConsciousWhenDead() {
        int initialHealth = burglar.getHealth();
        burglar.takeHit(initialHealth);  // Gör så att tjuven förlorar all sin hälsa.

        // Kontrollera att en död tjuv inte är medveten.
        assertFalse(burglar.isConscious(), "Burglar should not be conscious when health is 0 or below.");
    }
}