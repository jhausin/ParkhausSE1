package models;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Author: Axel Kirst
 */

public class Ticket {
    Date entrance;
    Date exit;
    public String licensePlate;
    public boolean isPaid = false;
    private int ticketID;
    public int numberOfTickets;
    private double price;
    private int duration;


    public Ticket(String lp, int id) {
        this.licensePlate = lp;
        this.entrance = new Date();
        this.ticketID = id;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payTicket(double p) {
        this.duration = (int) (exit.getTime() - entrance.getTime()) / 1000;
        this.price = duration * p;
    }

    public int getTicketID() {
        return this.ticketID;
    }

    public Date getEntranceDate() {
        return this.entrance;
    }

    public Date getExitDate() {
        return this.exit;
    }

    public double getPrice() {
        return this.price;
    }

    public int getDuration() {
        return this.duration;
    }

}
