package ee.taltech.iti0200.bonuscards.cards;
import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;
import ee.taltech.iti0200.bonuscards.exceptions.AlreadyExistingCardTypeException;
import ee.taltech.iti0200.bonuscards.exceptions.BonusException;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class BonusCard {

    public enum CardType { COOP, RIMI }

    /**
     * Creates a bonus card.
     *
     * @param cardType the card type to create
     * @param store the store to add the card to
     * @param person the person to add the card to
     * @return the bonus card that was created
     */
    public static BonusCard createCard(CardType cardType, Store store, Person person) {
        BonusCard card = null;
        if (person.getBonusCardByType(cardType).equals(Optional.empty()) && !store.getCustomers().contains(person)) {
            if (cardType.equals(CardType.COOP)) {
                card = new CoopCard(store, person);
            } else if (cardType.equals(CardType.RIMI)) {
                card = new RimiCard(store, person);
            }
            person.addBonusCard(card);
            store.addCustomer(person);
            return card;
        } else {
            throw new AlreadyExistingCardTypeException();
        }
    }

    public abstract BigDecimal collectBonus(double paymentAmount);
    public abstract CardType getCardType();
    public abstract Store getStoreName();
    public abstract BigDecimal getBalance();
    public abstract Person getPersonName();
    public abstract void setBalance(BigDecimal bonusBalance);

    /**
     * Uses the specified amount of bonus.
     *
     * @param value the bonus value to use
     * @return remaining bonus
     */
    public BigDecimal useBonus(BigDecimal value) {
        if (value.compareTo(getBonusBalance()) <= 0) {
            setBonusBalance(getBonusBalance().subtract(value));
            return getBonusBalance();
        } else {
            throw new BonusException();
        }
    }

    public void setBonusBalance(BigDecimal bonusBalance) {
        setBalance(bonusBalance);
    }
    public CardType getType() {
        return getCardType();
    }

    public Store getStore() {
        return getStoreName();
    }

    public BigDecimal getBonusBalance() {
        return getBalance();
    }

    public Person getPerson() {
        return getPersonName();
    }
}