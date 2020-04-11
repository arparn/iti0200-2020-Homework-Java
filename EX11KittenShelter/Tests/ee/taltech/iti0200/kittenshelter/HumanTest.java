package ee.taltech.iti0200.kittenshelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    public static final int MONEY1 = 100;
    public static final int MONEY2 = 200;

    Human human;
    Kitten kitten;
    Kitten kitten2;

    @BeforeEach
    void setUp() {
        this.human = new Human(MONEY1, "calm");
        this.kitten = new Kitten("Karl", "calm", "Black", 3, Kitten.Gender.MALE);
        this.kitten2 = new Kitten("Marta", "playful", "red", 5, Kitten.Gender.FEMALE);
    }

    @Test
    void addKitten() {
        human.addKitten(kitten);
        List<Kitten> kittens = new LinkedList<>();
        kittens.add(kitten);
        assertEquals(kittens, human.getAdoptedKittens());
    }

    @Test
    void getAdoptedKittens() {
        human.addKitten(kitten);
        human.addKitten(kitten2);
        List<Kitten> kittens = new LinkedList<>();
        kittens.add(kitten);
        kittens.add(kitten2);
        List<Kitten> adoptedKittens = human.getAdoptedKittens();
        assertEquals(kittens, adoptedKittens);
    }

    @Test
    void setMoney() {
        human.setMoney(MONEY2);
        assertEquals(MONEY2, human.getMoney());
    }

    @Test
    void setKittenCharacter() {
        human.setKittenCharacter("playful");
        assertEquals("playful", human.getKittenCharacter());
    }

    @Test
    void getMoney() {
        assertEquals(MONEY1, human.getMoney());
    }

    @Test
    void getKittenCharacter() {
        assertEquals("calm", human.getKittenCharacter());
    }
}
