package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {

        // no need to pass dto in the service, consider if there are some validations we need to perform which generateTicket() is not concerned about.
        Ticket ticket = ticketService.generateTicket(requestDto.getGateNumber(), requestDto.getVehicleNumber(), requestDto.getVehicleType());
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        return responseDto;
    }
}
