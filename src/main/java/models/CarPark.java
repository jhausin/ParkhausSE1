package models;

import interfaces.VehicleIF;

import java.util.Date;
import java.util.Random;

public class CarPark {

    private String name;
    private ParkingLot[] park;
    private double price;
    private int freeCarSpaces;
    private int freeLocalSpaces;
    private int freeDisabledSpaces;
    private int freeWomanSpaces;
    private int freeBikeSpaces;



    public CarPark(Config c){ //muss vorm aufruf getestet werden ob gesamt größer als die einzelnen sind

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


        for (int i =0; i < this.park.length; i++){
            if(numbOfWoman > 0){
                park[i] = new ParkingLot(false,true,false,false);
                numbOfWoman--;
            } else if(numbOfDisabled > 0){
                park[i] = new ParkingLot(false,false,false,true);
                numbOfDisabled--;
            } else if(numbOfLocal > 0){
                park[i] = new ParkingLot(false,false,true,false);
                numbOfLocal--;
            } else if(numbOfBike > 0){
                park[i] = new ParkingLot(true,false,false,false);
                numbOfBike--;
            } else {
                break;
            }
        }
        this.price = c.getPrice();
        this.name = c.getName();

    }


    public VehicleIF createVehicle(String lp, boolean l, boolean w, boolean d, boolean isBike){
        if (isBike){
            return new Bike(l, lp);
        } else {
            return new Car(w,d,l,lp);
        }
    }


    public VehicleIF createRandomVehicle(){
        Random rand = new Random();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lp;
        char[] plate = switch (rand.nextInt(3)) {
            case 0 -> new char[9];
            case 1 -> new char[10];
            default -> new char[11];
        };

        for (int i = 0; i < plate.length; i++) {
            if(i == 1 && plate.length == 9){
                plate[i] = '-';

            }
            else if(i == 2 && plate.length == 10){
                plate[i] = '-';

            }
            else if(i == 3 && plate.length == 11){
                plate[i] = '-';

            }
            else if(i == 4 && plate.length == 9){
                plate[i] = '-';

            }
            else if(i == 5 && plate.length == 10){
                plate[i] = '-';

            }
            else if(i == 6 && plate.length == 11){
                plate[i] = '-';

            }
            else if(i < plate.length-4){
                plate[i] = alphabet.charAt(rand.nextInt(alphabet.length()));
            }
            else{
                plate[i] = (char)('0' + rand.nextInt(10));
            }
        }
        lp = String.valueOf(plate);


        return switch (rand.nextInt(10)) {
            case 0 -> new Bike(false, lp);
            case 1 -> new Bike(true, lp);
            case 2 -> new Car(false, false, false, lp);
            case 3 -> new Car(false, false, true, lp);
            case 4 -> new Car(false, true, false, lp);
            case 5 -> new Car(true, false, false, lp);
            case 6 -> new Car(false, true, true, lp);
            case 7 -> new Car(true, true, false, lp);
            case 8 -> new Car(true, false, true, lp);
            case 9 -> new Car(true, true, true, lp);
            default -> null;
        };


    }//random vehicle constructor

    public void enter(){     //add women local disabled
        VehicleIF v = createRandomVehicle();
        if (v.isBike()){
            int ind = 0;
            while(this.freeBikeSpaces > 0){
                if (this.park[ind].isEmpty() && this.park[ind].isForBike){
                    park[ind].addVehicle(v);
                    freeBikeSpaces--;
                    return;
                }
                ind++;
            }
        } else if (v.isLocal()){
                int ind = 0;
                while(this.freeLocalSpaces > 0){
                    if (this.park[ind].isEmpty() && this.park[ind].isForLocal){
                        park[ind].addVehicle(v);
                        freeLocalSpaces--;
                        return;
                    }
                    ind++;
                }
        } else if (v.isDisabled()){
            int ind = 0;
            while(this.freeDisabledSpaces > 0){
                if (this.park[ind].isEmpty() && this.park[ind].isForDisabled){
                    park[ind].addVehicle(v);
                    freeDisabledSpaces--;
                    return;
                }
                ind++;
            }
        }  else if (v.isWoman()){
            int ind = 0;
            while(this.freeDisabledSpaces > 0){
                if (this.park[ind].isEmpty() && this.park[ind].isForWoman){
                    park[ind].addVehicle(v);
                    freeWomanSpaces--;
                    return;
                }
                ind++;
            }
        } else {
                int ind = 0;
                while(this.freeCarSpaces > 0){
                    if (this.park[ind].isEmpty() && !this.park[ind].isForBike){
                        this.park[ind].addVehicle(v);
                        return;
                }
                ind++;
            }
        }

    }

    public void leave(int v){             //Number instead of vehicle
        if(park[v] != null){
            if (!park[v].vehicle.getTicket().isPaid()) {

                park[v].vehicle.getTicket().payTicket();

            }
            if(park[v].vehicle.isWoman()) freeWomanSpaces++;
            else if(park[v].vehicle.isDisabled()) freeDisabledSpaces++;
            else if(park[v].vehicle.isLocal()) freeLocalSpaces++;
            else if(park[v].vehicle.isBike()) freeBikeSpaces++;
            else freeCarSpaces++;

            park[v].vehicle.getTicket().exit = new Date();
            park[v].removeVehicle();
        }

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

    public int getParkinglots(){
        return this.park.length;
    }

    private class ParkingLot {      //add woman local disabled
        VehicleIF vehicle = null;
        boolean isForBike;
        boolean isForWoman;
        boolean isForLocal;
        boolean isForDisabled;

        public ParkingLot(boolean b, boolean w, boolean l, boolean d){
            this.isForBike = b;
            this.isForDisabled = d;
            this.isForLocal = l;
            this.isForWoman = w;
        }

        public boolean isEmpty(){
            return vehicle == null;
        }

        public VehicleIF removeVehicle(){
            VehicleIF temp;
            temp = this.vehicle;
            this.vehicle = null;
            return temp;
        }
        public void addVehicle(VehicleIF v){
            this.vehicle = v;
        }
    }


}
