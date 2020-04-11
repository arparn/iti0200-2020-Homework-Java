package ee.taltech.iti0200.kittenshelter;

import java.time.LocalDate;

public class Kitten {

    public static final int ADOPTION_FEE = 40;

    public enum Gender {
        MALE,
        FEMALE,
    }

    private int kittenAdoptionFee;

    private boolean wash;
    private boolean makeHaircut;
    private boolean vaccine;
    private LocalDate arrivalToShelterDate;
    private String name;
    private String character;
    private String color;
    private int age;
    private Gender gender;

    public Kitten(String name, String character, String color, int age, Gender gender) {
        this.name = name;
        this.character = character;
        this.color = color;
        this.age = age;
        this.gender = gender;
        this.kittenAdoptionFee = ADOPTION_FEE;
        this.vaccine = false;
        this.wash = false;
        this.makeHaircut = false;
    }

    public void setArrivalTimeAny(LocalDate date) {
        this.arrivalToShelterDate = date;
    }

    public void setArrivalToShelterDate() {
        this.arrivalToShelterDate = LocalDate.now();
    }

    public LocalDate getArrivalToShelterDate() {
        return this.arrivalToShelterDate;
    }

    public void setVaccine() {
        this.vaccine = true;
    }

    public void setWash() {
        this.wash = true;
    }

    public void setMakeHaircut() {
        this.makeHaircut = true;
    }

    public boolean getVaccine() {
        return this.vaccine;
    }

    public boolean getWash() {
        return this.wash;
    }

    public boolean getMakeHaircut() {
        return this.makeHaircut;
    }

    public int getKittenAdoptionFee() {
        return this.kittenAdoptionFee;
    }

    public void addKittenAdoptionFee(int fee) {
        this.kittenAdoptionFee += fee;
    }

    public String getName() {
        return this.name;
    }

    public String getCharacter() {
        return this.character;
    }

    public String getColor() {
        return this.color;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }
}
