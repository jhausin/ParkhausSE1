import java.util.Date;

class Ticket{
    Date entrance;
    Date exit;
    String licensePlate;
    private boolean isPaid;
    private int ticketID;
    private int numberOfTickets;


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
}