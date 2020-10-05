package models;

import interfaces.VehicleIF;
import utilities.CustomerType;

public class Bike implements VehicleIF {

    Ticket t;
    CustomerType type;
    String licensePlate;

    public Bike(CustomerType x, String lp) {
        this.type = x;
        this.licensePlate = lp;
        this.t = new Ticket(lp);
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public CustomerType getType() {
        return this.type;
    }

    public Ticket getTicket() {
        return this.t;
    }


}
