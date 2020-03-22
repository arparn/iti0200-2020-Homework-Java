package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VehicleTest {

    public static final long NUMBER = 1234455668;
    public static final long NUMBER2 = 1547294638;
    public static final long NUMBER3 = 1249083245;

    Vehicle vehicle;
    Long vin;

    @BeforeEach
    void setUp() {
        this.vehicle = new Vehicle("1234455668");
        this.vin = NUMBER;

    }

    @Test
    void getVin() {
        assertEquals(vin, vehicle.getVin());
    }

    @Test
    void getName() {
        assertNull(vehicle.getName());
    }

    @Test
    void getBorderCrossingId() {
        vehicle.setBorderCrossingId(NUMBER2);
        assertEquals(NUMBER2, vehicle.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        vehicle.setBorderCrossingId(NUMBER3);
        assertEquals(NUMBER3, vehicle.getBorderCrossingId());
    }
}
