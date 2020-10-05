package models;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Ticket {
    Date entrance;
    Date exit;
    public String licensePlate;
    private boolean isPaid = false;
    private int ticketID;
    int numberOfTickets;
    private double price;


    public Ticket(String lp) {
        this.licensePlate = lp;
        this.entrance = new Date();
        numberOfTickets++;
        this.ticketID = numberOfTickets;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payTicket(double p) {
        this.price = (int) (exit.getTime() - entrance.getTime()) / 1000 * p;
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
}