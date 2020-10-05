package models;

import interfaces.VehicleIF;
import utilities.CustomerType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class CarPark {

    public String name;
    private ParkingLot[] park;
    private double price;
    private int freeCarSpaces;
    private int freeLocalSpaces;
    private int freeDisabledSpaces;
    private int freeWomanSpaces;
    private int freeBikeSpaces;
    public Config cfg;


    public CarPark(Config c) { //muss vorm aufruf getestet werden ob gesamt größer als die einzelnen sind

        this.cfg = c;
        this.park = new ParkingLot[c.getValue("total")];
        this.freeLocalSpaces = c.getValue("local");
        this.freeDisabledSpaces = c.getValue("disabled");
        this.freeWomanSpaces = c.getValue("women");
        this.freeBikeSpaces = c.getValue("bike");
        this.freeCarSpaces = this.park.length - this.freeWomanSpaces - this.freeBikeSpaces - this.freeDisabledSpaces - this.freeLocalSpaces;

        int numbOfWoman = this.freeWomanSpaces;
        int numbOfDisabled = this.freeDisabledSpaces;
        int numbOfLocal = this.freeLocalSpaces;
        int numbOfBike = this.freeBikeSpaces;


        for (int i = 0; i < this.park.length; i++) {
            if (numbOfWoman > 0) {
                park[i] = new ParkingLot(CustomerType.WOMEN);
                numbOfWoman--;
            } else if (numbOfDisabled > 0) {
                park[i] = new ParkingLot(CustomerType.DISABLED);
                numbOfDisabled--;
            } else if (numbOfLocal > 0) {
                park[i] = new ParkingLot(CustomerType.LOCAL);
                numbOfLocal--;
            } else if (numbOfBike > 0) {
                park[i] = new ParkingLot(CustomerType.BIKE);
                numbOfBike--;
            } else {
                park[i] = new ParkingLot(CustomerType.CAR);
            }
        }
        this.price = c.getPrice();
        this.name = c.getName();
    }


    public VehicleIF createVehicle(String lp, CustomerType x) {
        //return isBike ? new Bike(l, lp) : new Car(w,d,l,lp);
        if (x == CustomerType.BIKE) {
            return new Bike(CustomerType.BIKE, lp);
        } else {
            return new Car(x, lp);
        }
    }


    public VehicleIF createRandomVehicle() {
        Random rand = new Random();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lp;
        char[] plate = switch (rand.nextInt(3)) {
            case 0 -> new char[9];
            case 1 -> new char[10];
            default -> new char[11];
        };

        for (int i = 0; i < plate.length; i++) {
            if (i == 1 && plate.length == 9) {
                plate[i] = '-';

            } else if (i == 2 && plate.length == 10) {
                plate[i] = '-';

            } else if (i == 3 && plate.length == 11) {
                plate[i] = '-';

            } else if (i == 4 && plate.length == 9) {
                plate[i] = '-';

            } else if (i == 5 && plate.length == 10) {
                plate[i] = '-';

            } else if (i == 6 && plate.length == 11) {
                plate[i] = '-';

            } else if (i < plate.length - 4) {
                plate[i] = alphabet.charAt(rand.nextInt(alphabet.length()));
            } else {
                plate[i] = (char) ('0' + rand.nextInt(10));
            }
        }
        lp = String.valueOf(plate);


        return switch (rand.nextInt(5)) {
            case 0 -> new Bike(CustomerType.BIKE, lp);
            case 1 -> new Car(CustomerType.WOMEN, lp);
            case 2 -> new Car(CustomerType.DISABLED, lp);
            case 3 -> new Car(CustomerType.LOCAL, lp);
            case 4 -> new Car(CustomerType.CAR, lp);
            default -> null;
        };


    }//random vehicle constructor

    public void enter() {     //add women local disabled
        VehicleIF v = createRandomVehicle();
        enterVehicle(v);
    }

    public void enter(VehicleIF v) {     //add women local disabled
        enterVehicle(v);
    }

    public void enterVehicle(VehicleIF v) {

        int temp = 1;

        switch (v.getType()) {
            case WOMEN: {
                if (freeWomanSpaces > 0) {
                    for (int i = 0; i < cfg.getValue("women"); i++) {
                        if (this.park[i].isEmpty() && this.park[i].type == CustomerType.WOMEN) {
                            park[i].addVehicle(v);
                            freeWomanSpaces--;
                            return;
                        }
                        temp++;
                    }

                }
            }
            case DISABLED: {
                if (freeDisabledSpaces > 0) {
                    for (int i = temp; i < temp + cfg.getValue("disabled"); i++) {
                        if (this.park[i].isEmpty() && this.park[i].type == CustomerType.DISABLED) {
                            park[i].addVehicle(v);
                            freeDisabledSpaces--;
                            return;
                        }
                    }

                }
            }
            case LOCAL: {
                if (freeLocalSpaces > 0) {
                    for (int i = temp; i < temp + cfg.getValue("local"); i++) {
                        if (this.park[i].isEmpty() && this.park[i].type == CustomerType.LOCAL) {
                            park[i].addVehicle(v);
                            freeLocalSpaces--;
                            return;
                        }
                    }

                }
            }
            case BIKE: {
                if (freeBikeSpaces > 0) {
                    for (int i = temp; i < temp + cfg.getValue("bike"); i++) {
                        if (this.park[i].isEmpty() && this.park[i].type == CustomerType.BIKE) {
                            park[i].addVehicle(v);
                            freeBikeSpaces--;
                            return;
                        }
                    }

                }
            }
            case CAR: {
                for (int i = temp; i < cfg.getValue("total"); i++) {
                    if (this.park[i].isEmpty() && this.park[i].type == CustomerType.CAR) {
                        park[i].addVehicle(v);
                        freeCarSpaces--;
                        return;
                    }
                }

            }
        }
    }

    public void leave(int v) {             //Number instead of vehicle
        if (v < park.length && v >= 0 && park[v].vehicle != null) {
            if (park[v].vehicle.getType() == CustomerType.WOMEN) freeWomanSpaces++;
            else if (park[v].vehicle.getType() == CustomerType.DISABLED) freeDisabledSpaces++;
            else if (park[v].vehicle.getType() == CustomerType.LOCAL) freeLocalSpaces++;
            else if (park[v].vehicle.getType() == CustomerType.BIKE) freeBikeSpaces++;
            else freeCarSpaces++;

            park[v].vehicle.getTicket().exit = new Date();
            if (!park[v].vehicle.getTicket().isPaid()) {

                park[v].vehicle.getTicket().payTicket(this.price);

            }
            park[v].removeVehicle();
        }

    }

    public VehicleIF leaveRandom() {             //Number instead of vehicle
        Random random = new Random();
        while (getFreeSpaces() < park.length) {
            int v = random.nextInt(getParkinglots());
            if (park[v].vehicle != null) {

                if (park[v].vehicle.getType() == CustomerType.WOMEN) freeWomanSpaces++;
                else if (park[v].vehicle.getType() == CustomerType.DISABLED) freeDisabledSpaces++;
                else if (park[v].vehicle.getType() == CustomerType.LOCAL) freeLocalSpaces++;
                else if (park[v].vehicle.getType() == CustomerType.BIKE) freeBikeSpaces++;
                else freeCarSpaces++;

                park[v].vehicle.getTicket().exit = new Date();
                if (!park[v].vehicle.getTicket().isPaid()) {

                    park[v].vehicle.getTicket().payTicket(this.price);

                }
                return park[v].removeVehicle();

            }
        }
        return null;
    }

    public int getFreeCarSpaces() {
        return this.freeCarSpaces;
    }

    public int getFreeLocalSpaces() {
        return this.freeLocalSpaces;
    }

    public int getFreeDisabledSpaces() {
        return this.freeDisabledSpaces;
    }

    public int getFreeWomanSpaces() {
        return this.freeWomanSpaces;
    }

    public int getFreeBikeSpaces() {
        return this.freeBikeSpaces;
    }

    public double getPrice() {
        return this.price;
    }

    public int getParkinglots() {
        return this.park.length;
    }

    private class ParkingLot {      //add woman local disabled
        VehicleIF vehicle = null;
        CustomerType type;

        public ParkingLot(CustomerType c) {
            this.type = c;
        }

        public boolean isEmpty() {
            return vehicle == null;
        }

        public VehicleIF removeVehicle() {
            VehicleIF temp;
            temp = this.vehicle;
            this.vehicle = null;
            return temp;
        }

        public void addVehicle(VehicleIF v) {
            this.vehicle = v;
        }
    }

    public String toString() {
        return "Funzt";
    }

    public int getFreeSpaces() {
        return this.freeBikeSpaces + this.freeCarSpaces + this.freeDisabledSpaces + this.freeLocalSpaces + this.freeWomanSpaces;
    }


}
