package utilities;

import interfaces.VehicleIF;
import models.Car;
import models.CarPark;
import models.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.JsonObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.responseUtilities.createVehicleAsJson;

/**
 * Author: Joshua Bäuml
 */

class responseUtilitiesTest {

    CarPark ph;
    VehicleIF car;
    JsonObject v;

    @BeforeEach
    void init() {
        ph = new CarPark(new Config());
        car = new Car(CustomerType.LOCAL, "K-AB-1234", 1);
        ph.enter(car);
        car = ph.leaveRandom();
        v = createVehicleAsJson(car, ph.getFreeSpaces());
    }

    @Test
    void createVehicleAsJson_CustomerType() {
        assertEquals("LOCAL", v.getString("CustomerType"));
    }

    @Test
    void createVehicleAsJson_Licenseplate() {
        assertEquals(car.getLicensePlate(), v.getString("LicensePlate"));
    }

    @Test
    void createVehicleAsJson_EntryDate() {
        assertEquals(car.getTicket().getEntranceDate().toString(), v.getString("EntryDate"));
    }

    @Test
    void createVehicleAsJson_ExitDate() {
        assertEquals(car.getTicket().getExitDate().toString(), v.getString("ExitDate"));
    }

    @Test
    void createVehicleAsJson_Price() {
        assertEquals(car.getTicket().getPrice(), v.getInt("Price"));
    }

    @Test
    void createVehicleAsJson_TicketID() {
        assertEquals(car.getTicket().getTicketID(), v.getInt("TicketID"));
    }


}