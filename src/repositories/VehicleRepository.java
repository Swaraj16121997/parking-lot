package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    // Using Map for in-memory DB (non-persistent). Map<VehicleNumber, Vehicle>
    Map<String, Vehicle> vehicleStore;

    public VehicleRepository() {
        vehicleStore = new HashMap<>();
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleStore.get(vehicleNumber);
    }

    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicleStore.put(vehicle.getNumber(), vehicle);
        return vehicle;
    }
}
