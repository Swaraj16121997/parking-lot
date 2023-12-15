package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import exceptions.NoParkingSpotFoundException;
import models.Ticket;
import models.TicketGenerationResponseStatus;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try {
            // no need to pass dto in the service, consider if there are some validations we need to perform which generateTicket() is not concerned about.
            Ticket ticket = ticketService.generateTicket(requestDto.getGateNumber(), requestDto.getVehicleNumber(), requestDto.getVehicleType());

            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(TicketGenerationResponseStatus.SUCCESS);
        } catch (NoParkingSpotFoundException e) {

            responseDto.setResponseStatus(TicketGenerationResponseStatus.FAILURE);
            responseDto.setFailureMessage(e.getMessage());
        } catch (Exception e) {
            responseDto.setResponseStatus(TicketGenerationResponseStatus.FAILURE);
            responseDto.setFailureMessage("Something went wrong");
        }

        return responseDto;
    }
}
