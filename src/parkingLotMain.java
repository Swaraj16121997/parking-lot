import controllers.TicketController;
import repositories.TicketRepository;
import services.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class parkingLotMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot!");

//        General way of creating depended objects
//        GenerateTicketRequestDto generateTicketRequestDto =
//                new GenerateTicketRequestDto();
//        /*--*/
//        TicketController ticketController = new TicketController();
//        ticketController.generateTicket(generateTicketRequestDto);

        ObjectContainer objectContainer = new ObjectContainer();

        TicketRepository ticketRepository = new TicketRepository();
        objectContainer.addObject("ticketRepository", ticketRepository);

        TicketService ticketService = new TicketService((TicketRepository) objectContainer.getObject("ticketRepository"));
        objectContainer.addObject("ticketService", ticketService);

        TicketController ticketController = new TicketController((TicketService) objectContainer.getObject("ticketService"));
        objectContainer.addObject("ticketController", ticketController);
    }
}