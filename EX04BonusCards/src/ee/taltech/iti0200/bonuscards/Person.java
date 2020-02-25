package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import ee.taltech.iti0200.bonuscards.exceptions.PersonException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private Set<BonusCard> bonusCards = new HashSet<>();

    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (age < 1) {
            throw new PersonException();
        } else {
            this.age = age;
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Set<BonusCard> getBonusCards() {
        return bonusCards;
    }

    /**
     * Gets bonus card by the specified type.
     *
     * @param cardType the bonus card type
     * @return bonus card with the specified type
     */
    public Optional<BonusCard> getBonusCardByType(BonusCard.CardType cardType) {
        for (BonusCard card : bonusCards) {
            if (card.getType() == cardType) {
                return Optional.of(card);
            }
        }
        return Optional.empty();
    }

    public void addBonusCard(BonusCard bonusCard) {
        bonusCards.add(bonusCard);
    }

    public void removeBonusCard(BonusCard bonusCard) {
        bonusCards.remove(bonusCard);
    }
}
