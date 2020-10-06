package models;

import interfaces.VehicleIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.CustomerType;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joshua Bäuml
 */

class VehicleIFTest {

    VehicleIF bike;

    @BeforeEach
    void init() {
        bike = new Bike(CustomerType.BIKE, "K-AB-1234", 1);
    }

    @Test
    void getLicensePlate() {
        assertEquals("K-AB-1234", bike.getLicensePlate());
    }

    @Test
    void getType() {
        assertEquals(CustomerType.BIKE, bike.getType());
    }

    @Test
    void getTicket() {
        assertEquals(bike.getLicensePlate(), bike.getTicket().licensePlate);
    }


}