package models;

import interfaces.VehicleIF;
import utilities.CustomerType;

public class Car implements VehicleIF {

    public CustomerType type;
    private Ticket t;
    String licensePlate;

    public Car(CustomerType x, String plate, int id) {

        this.type = x;
        this.licensePlate = plate;
        this.t = new Ticket(licensePlate, id);

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
