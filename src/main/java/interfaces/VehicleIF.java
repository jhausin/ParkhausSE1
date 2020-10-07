package interfaces;

import models.Ticket;
import utilities.CustomerType;

/**
 * Author: Joshua Bäuml
 */
public interface VehicleIF {
    String getLicensePlate();

    CustomerType getType();

    Ticket getTicket();

}
