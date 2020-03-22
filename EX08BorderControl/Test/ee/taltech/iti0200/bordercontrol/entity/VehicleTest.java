package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VehicleTest {

    Vehicle vehicle;
    Long vin;

    @BeforeEach
    void setUp() {
        this.vehicle = new Vehicle("1234455668");
        this.vin = (long) 1234455668;

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
        vehicle.setBorderCrossingId((long) 1547294638);
        assertEquals((long) 1547294638, vehicle.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        vehicle.setBorderCrossingId((long) 1249083245);
        assertEquals((long) 1249083245, vehicle.getBorderCrossingId());
    }
}
