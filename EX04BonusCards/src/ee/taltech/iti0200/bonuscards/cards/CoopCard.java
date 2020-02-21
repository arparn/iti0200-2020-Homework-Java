package ee.taltech.iti0200.bonuscards.cards;
import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

public final class CoopCard extends BonusCard {
    CoopCard(Store store, Person person) {

    }

    /**
     * Collects bonus on the specified payment amount.
     *
     * @param paymentAmount the payment amount
     * @return collected bonus
     */
    @Override
    public BigDecimal collectBonus(double paymentAmount) {
        return null;
    }
}