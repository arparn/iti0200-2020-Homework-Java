package ee.taltech.iti0200.bonuscards.cards;
import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

public final class CoopCard extends BonusCard {

    private Store store;
    private Person person;
    private CardType type = CardType.COOP;
    private BigDecimal balance = BigDecimal.valueOf(10.0);

    CoopCard(Store store, Person person) {
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
        double bonus = (paymentAmount * 5) / 100;
        balance = balance.add(BigDecimal.valueOf(bonus));
        return BigDecimal.valueOf(bonus);
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
