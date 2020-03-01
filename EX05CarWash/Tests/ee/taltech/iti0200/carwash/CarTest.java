package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(5);
    }

    @Test
    void setDirtiness() {
        car.setDirtiness(10);
        assertEquals(10, car.getDirtiness());
    }

    @Test
    void getDirtiness() {
        assertEquals(5, car.getDirtiness());
    }
}