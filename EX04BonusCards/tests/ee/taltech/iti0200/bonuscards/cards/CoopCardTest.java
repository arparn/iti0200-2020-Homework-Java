package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CoopCardTest {

    BonusCard coopCard;
    Store coop;
    Person mari;

    @BeforeEach
    void setUp() {
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        coop = new Store("Coop");
        coopCard = new CoopCard(coop, mari);
    }

    @Test
    void collectBonus() {
        BonusCard mariBonusCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        assertEquals(BigDecimal.valueOf(5.0), mariBonusCard.collectBonus(100));
    }

    @Test
    void getCardType() {
        assertEquals(BonusCard.CardType.COOP, coopCard.getCardType());
    }

    @Test
    void getStoreName() {
        assertEquals(coop, coopCard.getStoreName());
    }

    @Test
    void getBalance() {
        assertEquals(BigDecimal.valueOf(10.0), coopCard.getBalance());
    }

    @Test
    void getPersonName() {
        assertEquals(mari, coopCard.getPersonName());
    }

    @Test
    void setBalance() {
        coopCard.setBalance(BigDecimal.valueOf(100.0));
        assertEquals(BigDecimal.valueOf(100.0), coopCard.getBalance());
    }
}