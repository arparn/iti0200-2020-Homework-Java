package ee.taltech.iti0200.generics;

import ee.taltech.iti0200.generics.foods.Food;

import java.util.Optional;

public class AnimalBox<T extends Animal> {

    private T animal;

    public void put(T animal) {
        this.animal = animal;
    }

    public Optional<T> getAnimal() {
        return Optional.ofNullable(this.animal);
    }

    public void sound() {
        if (getAnimal().isPresent()) {
            animal.sound();
        }
    }

    public <K extends Food> void feed(K food) {
        if (getAnimal().isPresent()) {
            System.out.println(animal.name + " was fed with " + food.getName());
        }
    }
}
