package ee.taltech.iti0200.kittenshelter;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class KittenShelter {

    public static final int ADD_FEE1 = 5;
    public static final int ADD_FEE2 = 10;
    public static final int ADD_FEE3 = 20;
    public static final int DAYS = 3;

    private int kittenMax;

    List<Kitten> kittens = new LinkedList<>();

    public KittenShelter(int kittenMax) {
        this.kittenMax = kittenMax;
    }

    public List<Kitten> getKittens() {
        return this.kittens;
    }

    public void addKitten(Kitten kitten) {
        if (kittens.size() + 1 <= kittenMax) {
            kitten.setArrivalToShelterDate();
            kittens.add(kitten);
        }
    }

    public boolean checkQuarantineTime(Kitten kitten) {
        LocalDate arrival = kitten.getArrivalToShelterDate();
        LocalDate quarantineEnd = arrival.plusDays(DAYS);
        return LocalDate.now().compareTo(quarantineEnd) > 0;
    }

    public void giveVaccine(Kitten kitten) {
        if (!kitten.getVaccine()) {
            kitten.setVaccine();
            kitten.addKittenAdoptionFee(ADD_FEE3);
        }
    }

    public void wash(Kitten kitten) {
        if (!kitten.getWash()) {
            kitten.setWash();
            kitten.addKittenAdoptionFee(ADD_FEE1);
        }
    }

    public void makeHaircut(Kitten kitten) {
        if (!kitten.getMakeHaircut()) {
            kitten.setMakeHaircut();
            kitten.addKittenAdoptionFee(ADD_FEE2);
        }
    }

    public Optional<Kitten> adopt(Human human) {
        for (Kitten kitten : kittens) {
            if ((checkQuarantineTime(kitten)) && (kitten.getCharacter().equals(human.getKittenCharacter()))
                    && (human.getMoney() - kitten.getKittenAdoptionFee() >= 0)) {
                human.setMoney(human.getMoney() - kitten.getKittenAdoptionFee());
                human.addKitten(kitten);
                kittens.remove(kitten);
                return Optional.of(kitten);
            }
        }
        return Optional.empty();
    }
}
