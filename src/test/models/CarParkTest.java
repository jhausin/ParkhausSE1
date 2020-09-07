package models;

import interfaces.VehicleIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarParkTest {

    CarPark ph;
    VehicleIF car;

    @BeforeEach
    void init(){
        ph=new CarPark(15,2,2,5,2,2.5);
        car=new Car(false,false,false,"K-ABCD-1234");

    }

    @Test
    void checkNumberOfParkspaces_AssertTrue(){
        assertTrue(ph.getParkinglots()>=ph.getFreeBikeSpaces()+ph.getFreeDisabledSpaces()+ph.getFreeLocalSpaces()+ph.getFreeWomanSpaces());
    }

    @Test
    void createRandomVehicle() {
    }

    @Test
    void enter() {
    }

    @Test
    void leave() {
    }
}