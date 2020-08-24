public class Car implements VehicleIF {

    private boolean woman;
    private boolean disabled;
    private boolean local;
    private Ticket t;
    String licensePlate;

    public Car(boolean w, boolean d, boolean l, String plate){
        this.woman = w;
        this.disabled = d;
        this.local = l;
        this.licensePlate = plate;
        this.t = new Ticket(licensePlate);

    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public boolean isWoman() {
        return this.woman;
    }
    public boolean isDisabled() {
        return this.disabled;
    }
    public boolean isLocal() {
        return this.local;
    }
    public Ticket getTicket(){
        return this.t;
    }

    public boolean isBike() {
        return false;
    }

}
