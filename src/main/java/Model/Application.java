package Model;

import Service.TicketService;
import Service.TicketServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Account account = new Account(100L);

        /*The map will have key as TicketRequest and value as number of ticket required.
        Ideally, each category of ticket type will have an entry if selected by user.
        For example, it will have an entry for one adult ticket */

        final Map<TicketTypeRequest, Integer> ticketRequests = new HashMap<>();
        ticketRequests.put(TicketTypeRequest.ADULT, 10);
        ticketRequests.put(TicketTypeRequest.CHILD, 2);
        ticketRequests.put(TicketTypeRequest.INFANT, 5);

        TicketService ticketService = new TicketServiceImpl();
        ticketService.purchaseTickets(account.getAccountId(), ticketRequests);

    }
}