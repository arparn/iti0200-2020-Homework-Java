package ee.taltech.iti0200.bonuscards;
import ee.taltech.iti0200.bonuscards.cards.BonusCard;

import java.math.BigDecimal;

public class BonusCardExample {
    public static void main(String[] args) {

        Store coop = new Store("Coop");
        Store rimi = new Store("Rimi");

        Person kalle = new Person(
                "Kalle",
                "Kuusk",
                18,
                Person.Gender.MALE
        );

        Person malle = new Person(
                "Malle",
                "Mänd",
                35,
                Person.Gender.MALE
        );

        BonusCard kalleCoopBonusCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, kalle);
        BonusCard malleCoopBonusCard = BonusCard.createCard(BonusCard.CardType.COOP, coop, malle);

        System.out.println(kalleCoopBonusCard.getBonusBalance());  // 10
        System.out.println(malleCoopBonusCard.getBonusBalance());  // 10

        kalleCoopBonusCard.collectBonus(100);
        malleCoopBonusCard.collectBonus(100);

        System.out.println(kalleCoopBonusCard.getBonusBalance());  // 15.000
        System.out.println(malleCoopBonusCard.getBonusBalance());  // 1.000

        //kalleCoopBonusCard.useBonus(BigDecimal.valueOf(10));
        //malleRimiBonusCard.useBonus(BigDecimal.valueOf(1000000));  // BonusException

        //System.out.println(kalleCoopBonusCard.getBonusBalance());  // 5.000
        //System.out.println(malleRimiBonusCard.getBonusBalance());  // 1.000
        System.out.println(kalle);
        System.out.println(malle);
        System.out.println(coop.getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType.COOP, 55));
    }
}