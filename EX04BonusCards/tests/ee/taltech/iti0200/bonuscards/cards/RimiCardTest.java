package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RimiCardTest {

    Store rimi;
    BonusCard rimiCard;
    Person malle;

    @BeforeEach
    void setUp() {
        rimi = new Store("Rimi");
        malle = new Person("Malle", "Mänd", 25, Person.Gender.MALE);
        rimiCard = BonusCard.createCard(BonusCard.CardType.RIMI, rimi, malle);
    }

    @Test
    void collectBonus() {
        assertEquals(BigDecimal.valueOf(1.0), rimiCard.collectBonus(50));
    }

    @Test
    void getCardType() {
        assertEquals(BonusCard.CardType.RIMI, rimiCard.getCardType());
    }

    @Test
    void getStoreName() {
        assertEquals(rimi, rimiCard.getStoreName());
    }

    @Test
    void getBalance() {
        rimiCard.setBalance(BigDecimal.valueOf(100.0));
        assertEquals(BigDecimal.valueOf(100.0), rimiCard.getBalance());
    }

    @Test
    void getPersonName() {
        assertEquals(malle, rimiCard.getPersonName());
    }

    @Test
    void setBalance() {
        rimiCard.setBalance(BigDecimal.valueOf(100.0));
        assertEquals(BigDecimal.valueOf(100.0), rimiCard.getBalance());
    }
}