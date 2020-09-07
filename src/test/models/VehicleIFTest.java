package models;

import interfaces.VehicleIF;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VehicleIFTest {

    VehicleIF bike;
    VehicleIF car;
    VehicleIF notLocal;
    VehicleIF wrongPlate;

    @BeforeEach
    void init(){
        bike=new Bike(true,"K-T-01");
        car=new Car(true,false,true,"A-T-02");
        notLocal=new Bike(false,"BO-T-03");
        wrongPlate=new Car(false,false,true,"C-T-04");
    }

    @org.junit.jupiter.api.Test
    void CarGetLicensePlate_AssertEquals() {
        assertEquals("A-T-02",car.getLicensePlate());
    }

    @org.junit.jupiter.api.Test
    void CarGetLicensePlate_AssertNotEquals() {
        assertNotEquals("Un-f-ug",wrongPlate.getLicensePlate());
    }

    @org.junit.jupiter.api.Test
    void CarIsLocal_AssertTrue() {
        assertTrue(car.isLocal());
    }

    @org.junit.jupiter.api.Test
    void CarGetTicket_ByLicenseplate_AssertNotEquals(){
        assertNotEquals(car.getTicket().licensePlate,wrongPlate.getTicket().licensePlate);
    }

    @org.junit.jupiter.api.Test
    void CarIsBike_AssertFalse(){
        assertFalse(car.isBike());
    }

    @org.junit.jupiter.api.Test
    void BikeGetLicensePlateB_AssertEquals() {
        assertEquals("K-T-01",bike.getLicensePlate());
    }

    @org.junit.jupiter.api.Test
    void BikeIsLocal_AssertTrue() {
        assertTrue(bike.isLocal());
    }

    @org.junit.jupiter.api.Test
    void BikeIsLocal_AssertFalse() {
        assertFalse(notLocal.isLocal());
    }

    @org.junit.jupiter.api.Test
    void BikeGetTicket_ByLicenseplate_AssertEquals() {
        assertEquals(bike.getLicensePlate(),bike.getTicket().licensePlate);
    }

    @org.junit.jupiter.api.Test
    void BikeIsBike_AssertTrue() {
        assertTrue(bike.isBike());
    }


}