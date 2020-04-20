package ee.taltech.iti0200.burgerbooth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    Food cheeseBurger;
    Food chickenWrap;

    @BeforeEach
    void setUp() {
        cheeseBurger = new Food("Cheese Burger");
        chickenWrap = new Food("ChickenWrap");
    }

    @Test
    void getName() {
        assertEquals("Cheese Burger", cheeseBurger.getName());
    }

    @Test
    void setFood() {
        chickenWrap.setFood("Chicken Wrap");
        assertEquals("Chicken Wrap", chickenWrap.getName());
    }
}