package services;

import dtos.GenerateTicketRequestDto;
import exceptions.NoParkingSpotFoundException;
import models.*;
import repositories.TicketRepository;
import strategies.FirstAvailableSpotAssignmentStrategy;

import java.time.LocalDateTime;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;
    private ParkingLotService parkingLotService;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(int gateNumber, String vehicleNumber, VehicleType vehicleType) throws NoParkingSpotFoundException {

        // 1. Get vehicle from DB using vehicleNumber, if Vehicle is not found, register vehicle in the DB.
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null) {
            vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateNumber);

        // 2. Assign a parking spot to the vehicle
        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicle,gate);
        if(parkingSpot == null) {
            throw new NoParkingSpotFoundException("No parking spot found for your vehicle");
        }

        // 3. Update status of the parking spot
        parkingSpot = parkingSpotService.assignParkingSpot(parkingSpot);

        // 4. Create a ticket

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(LocalDateTime.now());

        // 5. Save ticket in DB
        ticketRepository.saveTicket(ticket);

        return ticket;
    }
}
