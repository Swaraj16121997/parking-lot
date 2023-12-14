package models;

import java.util.List;

public class ParkingSpot extends Base{
    private int number;
    private Floor floor;
    private List<VehicleType> eligibleSpots;    // if for eg. there is an EV which does not require a charging spot and EV spots are filled, still it will be eligible to park in small/med/large type spots
    private SpotStatus status;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public List<VehicleType> getEligibleSpots() {
        return eligibleSpots;
    }

    public void setEligibleSpots(List<VehicleType> eligibleSpots) {
        this.eligibleSpots = eligibleSpots;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }
}
