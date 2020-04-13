package ee.taltech.iti0200.kittenshelter;

import java.util.LinkedList;
import java.util.List;

public class Human {

    private int money;
    private String kittenCharacter;

    public Human(int money, String character) {
        this.money = money;
        this.kittenCharacter = character;
    }

    List<Kitten> adoptedKittens = new LinkedList<>();

    public void addKitten(Kitten kitten) {
        adoptedKittens.add(kitten);
    }

    public List<Kitten> getAdoptedKittens() {
        return this.adoptedKittens;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setKittenCharacter(String character) {
        this.kittenCharacter = character;
    }

    public int getMoney() {
        return this.money;
    }

    public String getKittenCharacter() {
        return this.kittenCharacter;
    }
}

