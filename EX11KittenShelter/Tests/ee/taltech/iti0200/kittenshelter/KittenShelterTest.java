package ee.taltech.iti0200.kittenshelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KittenShelterTest {

    Human human;
    Kitten kitten;
    Kitten kitten2;
    Kitten kitten3;
    KittenShelter shelter;

    @BeforeEach
    void setUp() {
        this.human = new Human(100, "calm");
        this.kitten = new Kitten("Karl", "calm", "Black", 3, Kitten.Gender.MALE);
        this.kitten2 = new Kitten("Marta", "playful", "red", 5, Kitten.Gender.FEMALE);
        this.kitten3 = new Kitten("Tom", "angry", "grey", 6, Kitten.Gender.MALE);
        this.shelter = new KittenShelter(2);
    }

    @Test
    void getKittens() {
        shelter.addKitten(kitten);
        shelter.addKitten(kitten3);
        List<Kitten> kittens = new LinkedList<>();
        kittens.add(kitten);
        kittens.add(kitten3);
        assertEquals(kittens, shelter.getKittens());
    }

    @Test
    void addKitten() {
        shelter.addKitten(kitten3);
        shelter.addKitten(kitten2);
        shelter.addKitten(kitten);
        List<Kitten> kittens = new LinkedList<>();
        kittens.add(kitten3);
        kittens.add(kitten2);
        List<Kitten> check = shelter.getKittens();
        assertEquals(kittens, check);
    }

    @Test
    void checkQuarantineTime() {
        shelter.addKitten(kitten);
        assertFalse(shelter.checkQuarantineTime(kitten));
    }

    @Test
    void giveVaccine() {
        shelter.giveVaccine(kitten);
        assertTrue(kitten.getVaccine());
    }

    @Test
    void wash() {
        shelter.wash(kitten2);
        assertTrue(kitten2.getWash());
    }

    @Test
    void makeHaircut() {
        shelter.makeHaircut(kitten3);
        assertTrue(kitten3.getMakeHaircut());
    }

    @Test
    void adopt() {
        shelter.addKitten(kitten);
        shelter.addKitten(kitten2);
        shelter.wash(kitten);
        shelter.giveVaccine(kitten);
        kitten.setArrivalTimeAny(LocalDate.now().minusDays(4));
        assertEquals(Optional.of(kitten), shelter.adopt(human));
    }
}
