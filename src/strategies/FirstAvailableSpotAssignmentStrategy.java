package strategies;

import models.ParkingSpot;
import models.SpotStatus;
import models.VehicleType;

import java.util.List;

public class FirstAvailableSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.getEligibleSpots().contains(vehicleType) && parkingSpot.getStatus().equals(SpotStatus.AVAILABLE)) {
                return parkingSpot;
            }
        }
        return null;
    }
}
