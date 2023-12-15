package services;

import models.Vehicle;
import models.VehicleType;
import repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = new VehicleRepository();
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicle(vehicleNumber);
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        return vehicleRepository.registerVehicle(new Vehicle(vehicleNumber, vehicleType));
    }
}
