package models;

import java.util.Date;

public class Ticket{
    Date entrance;
    Date exit;
    public String licensePlate;
    private boolean isPaid = false;
    private int ticketID;
    int numberOfTickets;


    public Ticket(String lp){
        this.licensePlate = lp;
        this.entrance = new Date();
        numberOfTickets++;
        this.ticketID = numberOfTickets;
    }

    public boolean isPaid(){
        return true;
    }

    public void payTicket(){
        this.isPaid = true;
    }

    public int getTicketID(){
        return this.ticketID;
    }
}