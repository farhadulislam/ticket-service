package Model;

import Model.TicketTypeRequest;
import Service.TicketService;
import Service.TicketServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        final Map<TicketTypeRequest, Integer> ticketRequests;
        ticketRequests = new HashMap<>();
        ticketRequests.put(TicketTypeRequest.ADULT, 1);
        ticketRequests.put(TicketTypeRequest.CHILD, 2);
        ticketRequests.put(TicketTypeRequest.INFANT, 16);

        TicketService ticketService = new TicketServiceImpl();
        ticketService.purchaseTickets( 100L, ticketRequests);

    }
}