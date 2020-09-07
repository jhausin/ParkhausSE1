package models;

import interfaces.VehicleIF;

public class Bike implements VehicleIF {

    Ticket t;
    boolean local;
    String licensePlate;

    public Bike(boolean l, String lp){
        this.local = l;
        this.licensePlate = lp;
        this.t = new Ticket(lp);
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isLocal() {
        return this.local;
    }
    public Ticket getTicket() {
        return this.t;
    }

    public boolean isBike() {
        return true;
    }

    public boolean isDisabled() {
        return false;
    }

    public boolean isWoman() {
        return false;
    }
}
