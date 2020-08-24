import java.util.Date;
import java.util.Random;

public class CarPark {

    private ParkingLot[] park;
    private double p1,p2;
    private int freeCarSpaces;
    private int freeBikeSpaces;


    public CarPark(int amountLots, double price1, double price2){
        this.park = new ParkingLot[amountLots];
        this.p1 = price1;
        this.p2 = price2;

    }

    public VehicleIF createVehicle(String lp, boolean l, boolean w, boolean d, boolean isBike){
        if (isBike){
            return new Bike(l, lp);
        } else {
            return new Car(w,d,l,lp);
        }
    }

    public void enter(VehicleIF v){

        if (v.isBike()){
            int ind = 0;
            while(this.freeBikeSpaces > 0){
                if (this.park[ind].isEmpty() && this.park[ind].isForBike){
                    park[ind].addVehicle(v);
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

    public void leave(VehicleIF v){
        for (ParkingLot parkingLot : this.park) {
            if (parkingLot.vehicle.getLicensePlate().equals(v.getLicensePlate()) && v.getTicket().isPaid()) {
                parkingLot.removeVehicle();
                v.getTicket().exit = new Date();
            }
        }
    }




    private class ParkingLot {
        VehicleIF vehicle = null;
        boolean isForBike = false;

        public ParkingLot(){
            if(Math.random() < 0.5){
                this.isForBike = true;
            }
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
