package ee.taltech.iti0200.bonuscards.cards;
import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

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
        return null;
    }

    public abstract BigDecimal collectBonus(double paymentAmount);

    /**
     * Uses the specified amount of bonus.
     *
     * @param value the bonus value to use
     * @return remaining bonus
     */
    public BigDecimal useBonus(BigDecimal value) {
        return null;
    }

    public void setBonusBalance(BigDecimal bonusBalance) {

    }

    public CardType getType() {
        return null;
    }

    public Store getStore() {
        return null;
    }

    public BigDecimal getBonusBalance() {
        return null;
    }

    public Person getPerson() {
        return null;
    }
}