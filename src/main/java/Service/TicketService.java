package Service;

import Model.TicketTypeRequest;
import Model.TicketTypeRequest2;

import java.util.Map;

public interface TicketService {

     public void purchaseTickets(Long accountId, Map<TicketTypeRequest, Integer> ticketRequests);
}
