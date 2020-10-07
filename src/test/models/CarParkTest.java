package models;

import interfaces.VehicleIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.CustomerType;

import java.util.regex.*;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Joshua Bäuml, Jannik Hausin
 */

class CarParkTest {

    CarPark ph;
    VehicleIF car;


    @BeforeEach
    void init() {
        ph = new CarPark(new Config());
        car = new Car(CustomerType.WOMEN, "K-AB-1234", 1);
    }

    @Test
    void checkNumberOfParkspaces_AssertTrue() {
        assertTrue(ph.getParkinglots() >= ph.getFreeBikeSpaces() + ph.getFreeDisabledSpaces() + ph.getFreeLocalSpaces() + ph.getFreeWomanSpaces());
    }

    @Test
    void createRandomVehicle() {
        VehicleIF vehicle = ph.createRandomVehicle();
        assertTrue(vehicle instanceof Car || vehicle instanceof Bike);
        assertTrue(vehicle.getLicensePlate().length() <= 11 && vehicle.getLicensePlate().length() >= 9);
        assertTrue(Pattern.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]{1,3}" + "[-]" + "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]{2}" + "[-]" + "[\\d]{4}", vehicle.getLicensePlate()));
        assertTrue(vehicle.getType() == CustomerType.WOMEN || vehicle.getType() == CustomerType.BIKE || vehicle.getType() == CustomerType.USUAL || vehicle.getType() == CustomerType.DISABLED || vehicle.getType() == CustomerType.LOCAL);
    }

    @Test
    void enter() {
        ph.enter();
        assertEquals(39, ph.getFreeBikeSpaces() + ph.getFreeCarSpaces() + ph.getFreeDisabledSpaces() + ph.getFreeLocalSpaces() + ph.getFreeWomanSpaces());
    }

    @Test
    void leave() {
        ph.enter(car);
        ph.leave(0);
        assertEquals(40, ph.getFreeBikeSpaces() + ph.getFreeCarSpaces() + ph.getFreeDisabledSpaces() + ph.getFreeLocalSpaces() + ph.getFreeWomanSpaces());
    }
}