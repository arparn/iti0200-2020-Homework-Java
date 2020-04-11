package ee.taltech.iti0200.kittenshelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class KittenTest {
    public static final int FEE = 40;
    public static final int ADD_FEE = 20;
    public static final int FINAL_FEE = 60;
    public static final int AGE = 3;

    Kitten kitten;
    Kitten kitten2;

    @BeforeEach
    void setUp() {
        this.kitten = new Kitten("Karl", "calm", "Black", 3, Kitten.Gender.MALE);
        this.kitten2 = new Kitten("Marta", "playful", "red", 5, Kitten.Gender.FEMALE);
    }

    @Test
    void setArrivalTimeAny() {
        kitten.setArrivalTimeAny(LocalDate.now());
        assertEquals(LocalDate.now(), kitten.getArrivalToShelterDate());
    }

    @Test
    void setArrivalToShelterDate() {
        kitten.setArrivalToShelterDate();
        assertEquals(LocalDate.now(), kitten.getArrivalToShelterDate());
    }

    @Test
    void getArrivalToShelterDate() {
        kitten2.setArrivalToShelterDate();
        LocalDate date = kitten2.getArrivalToShelterDate();
        assertEquals(LocalDate.now(), date);
    }

    @Test
    void setVaccine() {
        kitten.setVaccine();
        assertTrue(kitten.getVaccine());
    }

    @Test
    void setWash() {
        kitten.setWash();
        assertTrue(kitten.getWash());
    }

    @Test
    void setMakeHaircut() {
        kitten.setMakeHaircut();
        assertTrue(kitten.getMakeHaircut());
    }

    @Test
    void getVaccine() {
        kitten2.setVaccine();
        boolean check = kitten2.getVaccine();
        assertTrue(check);
    }

    @Test
    void getWash() {
        kitten2.setWash();
        boolean check = kitten2.getWash();
        assertTrue(check);
    }

    @Test
    void getMakeHaircut() {
        kitten2.setMakeHaircut();
        boolean check = kitten2.getMakeHaircut();
        assertTrue(check);
    }

    @Test
    void getKittenAdoptionFee() {
        assertEquals(FEE, kitten.getKittenAdoptionFee());
    }

    @Test
    void addKittenAdoptionFee() {
        kitten2.addKittenAdoptionFee(ADD_FEE);
        assertEquals(FINAL_FEE, kitten2.getKittenAdoptionFee());
    }

    @Test
    void getName() {
        assertEquals("Karl", kitten.getName());
    }

    @Test
    void getCharacter() {
        assertEquals("calm", kitten.getCharacter());
    }

    @Test
    void getColor() {
        assertEquals("Black", kitten.getColor());
    }

    @Test
    void getAge() {
        assertEquals(AGE, kitten.getAge());
    }

    @Test
    void getGender() {
        assertEquals(Kitten.Gender.MALE, kitten.getGender());
    }
}
