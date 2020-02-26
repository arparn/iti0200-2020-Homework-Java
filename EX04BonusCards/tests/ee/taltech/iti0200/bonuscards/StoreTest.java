package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store coop;

    @BeforeEach
    void setUp() {
        coop = new Store("Coop");
    }

    @Test
    void getName() {
        assertEquals("Coop", coop.getName());
    }

    @Test
    void getCustomers() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        coop.addCustomer(mari);
        Set<Person> customerSet = new HashSet<>();
        customerSet.add(mari);
        assertEquals(customerSet, coop.getCustomers());
    }

    @Test
    void addCustomer() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        coop.addCustomer(mari);
        Set<Person> customerSet = new HashSet<>();
        customerSet.add(mari);
        assertEquals(customerSet, coop.getCustomers());
    }

    @Test
    void removeCustomer() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        coop.addCustomer(mari);
        coop.removeCustomer(mari);
        Set<Person> customerSet = new HashSet<>();
        assertEquals(customerSet, coop.getCustomers());
    }

    @Test
    void getCustomerWithHighestBonusBalance() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        assertEquals(Optional.of(mari), coop.getCustomerWithHighestBonusBalance(BonusCard.CardType.COOP));
    }

    @Test
    void getCustomerWithLowestBonusBalanceYoungerThan() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        assertEquals(Optional.of(mari),
                coop.getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType.COOP, 20));
    }

    @Test
    void getTotalBonuses() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        assertEquals(BigDecimal.valueOf(10.0), coop.getTotalBonuses(BonusCard.CardType.COOP));
    }

    @Test
    void getAverageBonus() {
        Person mari = new Person("Mari", "Kuusk", 18, Person.Gender.MALE);
        BonusCard coopCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, mari);
        assertEquals(BigDecimal.valueOf(10.0), coop.getAverageBonus(BonusCard.CardType.COOP));
    }
}