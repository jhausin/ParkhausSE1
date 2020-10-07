package models;

import interfaces.VehicleIF;
import utilities.CustomerType;
/*
 *  Author: Joshua Bäuml
 */

public class Car implements VehicleIF {

    public CustomerType type;
    private Ticket t;
    String licensePlate;

    public Car(CustomerType x, String plate, int id) {

        this.type = x;
        this.licensePlate = plate;
        this.t = new Ticket(licensePlate, id);
        if (this.type.equals(CustomerType.LOCAL)) t.isPaid = true;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public CustomerType getType() {
        return this.type;
    }

    public Ticket getTicket() {
        return this.t;
    }

}
