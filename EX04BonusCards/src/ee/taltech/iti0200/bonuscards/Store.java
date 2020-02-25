package ee.taltech.iti0200.bonuscards;
import ee.taltech.iti0200.bonuscards.cards.BonusCard;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Store {

    private String name;
    private Set<Person> customerSet = new HashSet<>();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getCustomers() {
        return customerSet;
    }

    public void addCustomer(Person person) {
        customerSet.add(person);
    }

    public void removeCustomer(Person person){
        customerSet.remove(person);
    }

    /**
     * Gets customer with the highest bonus balance.
     *
     * @param cardType the bonus card type
     * @return customer with the highest bonus balance
     */
    public Optional<Person> getCustomerWithHighestBonusBalance(BonusCard.CardType cardType) {
        BigDecimal highestBalance = BigDecimal.ZERO;
        Person bestPerson = null;
        if (customerSet.size() > 0) {
            for (Person person : customerSet) {
                if (person.getBonusCardByType(cardType).isPresent()) {
                    BonusCard card = person.getBonusCardByType(cardType).get();
                    if (highestBalance.equals(BigDecimal.ZERO) || card.getBonusBalance().compareTo(highestBalance) > 0) {
                        highestBalance = card.getBonusBalance();
                        bestPerson = person;
                    }
                }
            }
            return Optional.ofNullable(bestPerson);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Gets customer with the lowest bonus balance who is younger than the specified age.
     *
     * @param cardType the bonus card type
     * @param age the age
     * @return customer
     */
    public Optional<Person> getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType cardType, int age) {
        BigDecimal lowestBalance = BigDecimal.ZERO;
        Person bestPerson = null;
        if (customerSet.size() > 0) {
            for (Person person : customerSet) {
                if (person.getBonusCardByType(cardType).isPresent()) {
                    BonusCard card = person.getBonusCardByType(cardType).get();
                    if ((person.getAge() < age || person.getAge() < bestPerson.getAge()) && (lowestBalance.equals(BigDecimal.ZERO) || card.getBonusBalance().compareTo(lowestBalance) < 0)) {
                        lowestBalance = card.getBonusBalance();
                        bestPerson = person;
                    }
                }
            }
            return Optional.ofNullable(bestPerson);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Gets total bonuses.
     *
     * @param cardType the bonus card type
     * @return the total bonuses
     */
    public BigDecimal getTotalBonuses(BonusCard.CardType cardType) {
        BigDecimal sumOfBonus = BigDecimal.ZERO;
        if (customerSet.size() > 0) {
            for (Person person : customerSet) {
                if (person.getBonusCardByType(cardType).isPresent()) {
                    BonusCard card = person.getBonusCardByType(cardType).get();
                    BigDecimal bonuses = card.getBonusBalance();
                    sumOfBonus = sumOfBonus.add(bonuses);
                }
            }
            return sumOfBonus;
        } else {
            return BigDecimal.ZERO;
        }
    }

    /**
     * Gets average bonus.
     *
     * @param cardType the bonus card type
     * @return the average bonus
     */
    public BigDecimal getAverageBonus(BonusCard.CardType cardType) {
        BigDecimal sumOfBonus = BigDecimal.ZERO;
        if (customerSet.size() > 0) {
            for (Person person : customerSet) {
                if (person.getBonusCardByType(cardType).isPresent()) {
                    BonusCard card = person.getBonusCardByType(cardType).get();
                    BigDecimal bonuses = card.getBonusBalance();
                    sumOfBonus = sumOfBonus.add(bonuses);
                }
            }
            return sumOfBonus.divide(BigDecimal.valueOf(customerSet.size()));
        } else {
            return BigDecimal.ZERO;
        }
    }
}