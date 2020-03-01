package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumWashTest {

    CarOwner martin = new CarOwner("Martin", 1500);
    Car car = new Car(10);

    @Test
    void wash() {
        WashStrategy washStrategy = new PremiumWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.wash(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void dry() {
        WashStrategy washStrategy = new PremiumWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.washAndDry(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void getWashAndDryPrice() {
        WashStrategy washStrategy = new PremiumWash();
        assertEquals(70, washStrategy.getWashAndDryPrice());
    }

    @Test
    void getWashPrice() {
        WashStrategy washStrategy = new PremiumWash();
        assertEquals(60, washStrategy.getWashPrice());
    }
}