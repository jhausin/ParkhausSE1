package interfaces;

import models.Ticket;
import utilities.CustomerType;

public interface VehicleIF {
    String getLicensePlate();

    CustomerType getType();

    Ticket getTicket();

}
