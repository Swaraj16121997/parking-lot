package strategies;

import models.ParkingSpot;
import models.VehicleType;

import java.util.List;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, List<ParkingSpot> parkingSpots);
}
