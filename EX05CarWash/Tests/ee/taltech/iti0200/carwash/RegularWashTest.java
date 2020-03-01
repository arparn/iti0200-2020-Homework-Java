package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularWashTest {

    CarOwner martin = new CarOwner("Martin", 1500);
    Car car = new Car(10);

    @Test
    void wash() {
        WashStrategy washStrategy = new RegularWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.wash(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void dry() {
        WashStrategy washStrategy = new RegularWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.washAndDry(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void getWashAndDryPrice() {
        WashStrategy washStrategy = new RegularWash();
        assertEquals(35, washStrategy.getWashAndDryPrice());
    }

    @Test
    void getWashPrice() {
        WashStrategy washStrategy = new RegularWash();
        assertEquals(30, washStrategy.getWashPrice());
    }
}