package ee.taltech.iti0200.bonuscards;
import ee.taltech.iti0200.bonuscards.cards.BonusCard;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class Store {
    public Store(String name) {

    }

    public String getName() {
        return null;
    }

    public Set<Person> getCustomers() {
        return null;
    }

    public void addCustomer(Person person) {

    }

    public void removeCustomer(Person person){

    }

    /**
     * Gets customer with the highest bonus balance.
     *
     * @param cardType the bonus card type
     * @return customer with the highest bonus balance
     */
    public Optional<Person> getCustomerWithHighestBonusBalance(BonusCard.CardType cardType) {
        return Optional.empty();
    }

    /**
     * Gets customer with the lowest bonus balance who is younger than the specified age.
     *
     * @param cardType the bonus card type
     * @param age the age
     * @return customer
     */
    public Optional<Person> getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType cardType, int age) {
        return Optional.empty();
    }

    /**
     * Gets total bonuses.
     *
     * @param cardType the bonus card type
     * @return the total bonuses
     */
    public BigDecimal getTotalBonuses(BonusCard.CardType cardType) {
        return null;
    }

    /**
     * Gets average bonus.
     *
     * @param cardType the bonus card type
     * @return the average bonus
     */
    public BigDecimal getAverageBonus(BonusCard.CardType cardType) {
        return null;
    }
}