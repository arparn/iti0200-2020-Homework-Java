package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarOwnerTest {

    CarOwner martin = new CarOwner("Martin", 1500);

    @Test
    void setBalance() {
        martin.setBalance(1000);
        assertEquals(1000, martin.getBalance());
    }

    @Test
    void getBalance() {
        assertEquals(1500, martin.getBalance());
    }

    @Test
    void getName() {
        assertEquals("Martin", martin.getName());
    }
}