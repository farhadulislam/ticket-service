package Service;

import Model.TicketTypeRequest;

import java.util.Map;

public interface TicketService {

     public void purchaseTickets(Long accountId, Map<TicketTypeRequest, Integer> ticketRequests);
}
