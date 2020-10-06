package utilities;

import interfaces.VehicleIF;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Author: Jannik Hausin
 */

public class responseUtilities {
    public static JsonObject createVehicleAsJson(VehicleIF v) {
        return Json.createObjectBuilder()
                .add("CustomerType", v.getType().name())
                .add("LicensePlate", v.getLicensePlate())
                .add("EntryDate", v.getTicket().getEntranceDate().toString())
                .add("ExitDate", v.getTicket().getExitDate().toString())
                .add("Price", v.getTicket().getPrice())
                .add("TicketID", v.getTicket().getTicketID())
                .build();
    }
}
