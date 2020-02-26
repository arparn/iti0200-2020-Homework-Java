package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFirstName() {
        Person mari;
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        assertEquals("Mari", mari.getFirstName());
    }

    @Test
    void getLastName() {
        Person mari;
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        assertEquals("Kuusk", mari.getLastName());
    }

    @Test
    void getAge() {
        Person mari;
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        assertEquals(18, mari.getAge());
    }

    @Test
    void getGender() {
        Person mari;
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        assertEquals(Person.Gender.MALE, mari.getGender());
    }

    @Test
    void getBonusCards() {
        Person mari;
        Store coop = new Store("Coop");
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        Set<BonusCard> bonusCards = new HashSet<>();
        bonusCards.add(coopCard);
        assertEquals(bonusCards, mari.getBonusCards());
    }

    @Test
    void getBonusCardByType() {
        Person mari;
        Store coop = new Store("Coop");
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        Set<BonusCard> bonusCards = new HashSet<>();
        bonusCards.add(coopCard);
        assertEquals(Optional.of(coopCard), mari.getBonusCardByType(BonusCard.CardType.COOP));
    }

    @Test
    void addBonusCard() {
        Person mari;
        Store coop = new Store("Coop");
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        Set<BonusCard> bonusCards = new HashSet<>();
        bonusCards.add(coopCard);
        mari.addBonusCard(coopCard);
        assertEquals(bonusCards, mari.getBonusCards());
    }

    @Test
    void removeBonusCard() {
        Person mari;
        Store coop = new Store("Coop");
        mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        Set<BonusCard> bonusCards = new HashSet<>();
        mari.addBonusCard(coopCard);
        mari.removeBonusCard(coopCard);
        assertEquals(bonusCards, mari.getBonusCards());
    }
}