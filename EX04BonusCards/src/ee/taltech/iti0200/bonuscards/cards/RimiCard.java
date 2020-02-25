package ee.taltech.iti0200.bonuscards.cards;
import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

public final class RimiCard extends BonusCard {

    private Store store;
    private Person person;
    private CardType type = CardType.RIMI;
    private BigDecimal balance = BigDecimal.ZERO;

    RimiCard(Store store, Person person) {
        this.store = store;
        this.person = person;
    }

    /**
     * Collects bonus on the specified payment amount.
     *
     * @param paymentAmount the payment amount
     * @return collected bonus
     */
    @Override
    public BigDecimal collectBonus(double paymentAmount) {
        if (paymentAmount >= 10) {
            double bonus = (paymentAmount * 2) / 100;
            balance = balance.add(BigDecimal.valueOf(bonus));
            return BigDecimal.valueOf(bonus);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public CardType getCardType() {
        return type;
    }

    @Override
    public Store getStoreName() {
        return store;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Person getPersonName() {
        return person;
    }

    @Override
    public void setBalance(BigDecimal bonusBalance) {
        balance = bonusBalance;
    }
}
