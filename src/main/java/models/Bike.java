package models;

import interfaces.VehicleIF;
import utilities.CustomerType;

/*
 * Author: Joshua Bäuml
 */

public class Bike implements VehicleIF {

    Ticket t;
    CustomerType type;
    String licensePlate;

    public Bike(CustomerType x, String lp, int id) {
        this.type = x;
        this.licensePlate = lp;
        this.t = new Ticket(lp, id);
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public CustomerType getType() {
        return this.type;
    }

    public Ticket getTicket() {
        return this.t;
    }


}
