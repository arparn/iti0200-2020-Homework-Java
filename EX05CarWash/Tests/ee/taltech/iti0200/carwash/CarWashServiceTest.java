package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarWashServiceTest {

    CarOwner martin = new CarOwner("Martin", 1500);
    Car bmw = new Car(100);
    Car audi = new Car(50);
    Car honda = new Car(30);
    CarWashService carWashService = new CarWashService();
    PremiumWash premiumWash = new PremiumWash();

    @Test
    void setWashStrategy() {
        carWashService.setWashStrategy(premiumWash);
        carWashService.washAndDry(bmw, martin);
        assertEquals(0, bmw.getDirtiness());
    }

    @Test
    void wash() {
        carWashService.setWashStrategy(premiumWash);
        carWashService.wash(audi, martin);
        assertEquals(0, audi.getDirtiness());
    }

    @Test
    void washAndDry() {
        carWashService.setWashStrategy(premiumWash);
        carWashService.washAndDry(honda, martin);
        assertEquals(0, honda.getDirtiness());
    }
}