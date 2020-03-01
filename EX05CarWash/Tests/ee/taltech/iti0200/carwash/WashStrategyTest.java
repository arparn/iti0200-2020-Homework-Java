package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WashStrategyTest {

    CarOwner martin = new CarOwner("Martin", 1500);
    Car car = new Car(10);

    @Test
    void isClientBlacklisted() {
        WashStrategy washStrategy = new PremiumWash();
        assertFalse(washStrategy.isClientBlacklisted(martin.getName()));
    }

    @Test
    void wash() {
        WashStrategy washStrategy = new CheapWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.wash(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void dry() {
        WashStrategy washStrategy = new CheapWash();
        CarWashService carWashService = new CarWashService();
        carWashService.setWashStrategy(washStrategy);
        carWashService.washAndDry(car, martin);
        assertEquals(0, car.getDirtiness());
    }

    @Test
    void getWashAndDryPrice() {
        WashStrategy washStrategy = new CheapWash();
        assertEquals(12, washStrategy.getWashAndDryPrice());
    }

    @Test
    void getWashPrice() {
        WashStrategy washStrategy = new CheapWash();
        assertEquals(10, washStrategy.getWashPrice());
    }

    @Test
    void setSessionDuration() {
        WashStrategy washStrategy = new CheapWash();
        washStrategy.setSessionDuration(15);
        assertEquals(15, washStrategy.getSessionDuration());
    }

    @Test
    void getSessionDuration() {
        WashStrategy washStrategy = new CheapWash();
        assertEquals(0, washStrategy.getSessionDuration());
    }

    @Test
    void setSessionPrice() {
        WashStrategy washStrategy = new CheapWash();
        washStrategy.setSessionPrice(20);
        assertEquals(20, washStrategy.getSessionPrice());
    }

    @Test
    void getSessionPrice() {
        WashStrategy washStrategy = new CheapWash();
        assertEquals(0, washStrategy.getSessionPrice());
    }
}