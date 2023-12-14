package dtos;

import models.Ticket;
import models.TicketGenerationResponseStatus;


public class GenerateTicketResponseDto {
    private Ticket ticket;
    private TicketGenerationResponseStatus responseStatus;
    private String failureMessage;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketGenerationResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(TicketGenerationResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
