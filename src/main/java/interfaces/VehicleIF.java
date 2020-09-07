package interfaces;

import models.Ticket;

public interface VehicleIF {



     String getLicensePlate();
     boolean isLocal();
     Ticket getTicket();
     boolean isBike();
     boolean isDisabled();
     boolean isWoman();

}
