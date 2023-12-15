package services;


import models.Gate;
import models.ParkingSpot;
import models.Vehicle;
import repositories.ParkingLotRepository;
import strategies.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    public ParkingLotService(ParkingLotRepository parkingLotRepository, SpotAssignmentStrategy spotAssignmentStrategy){
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate) {
        List<ParkingSpot> parkingSpots = parkingLotRepository.getAllParkingSpots();

        return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(), parkingSpots);
    }
}
