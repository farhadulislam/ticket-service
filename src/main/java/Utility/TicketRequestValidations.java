package Utility;

import java.util.Map;
import Model.TicketTypeRequest;
import Exception.AdultTicketAbsentException;
import Exception.MaximumNumberOfAuthorisedTicketsCrossedException;

import static Utility.Constants.Constraint.MAXIMUM_NUM_OF_PURCHASABLE_TICKETS;

public final class TicketRequestValidations {
    public static Boolean validateTicketRequestContainsAdult(Map<TicketTypeRequest, Integer> ticketRequests) {
        if (!ticketRequests.containsKey(TicketTypeRequest.ADULT) || ticketRequests.get(TicketTypeRequest.ADULT).equals(0))
            throw new AdultTicketAbsentException();
        return ticketRequests.containsKey(TicketTypeRequest.ADULT);
    }
    public static  Boolean validateTicketRequestIsNotEmpty(Map<TicketTypeRequest, Integer> ticketRequests) {
        if (ticketRequests.entrySet().isEmpty())
            throw new RuntimeException();
        return !ticketRequests.entrySet().isEmpty();
    }

    public static Boolean validateTotalNumOfTicketsNotMoreThanTwenty(Map<TicketTypeRequest, Integer> ticketRequests)   {
        int totalNumberOfTicketsRequested = ticketRequests.
                 values()
                .stream()
                .reduce(0, Integer::sum);

        if (totalNumberOfTicketsRequested > MAXIMUM_NUM_OF_PURCHASABLE_TICKETS)
            throw new MaximumNumberOfAuthorisedTicketsCrossedException();

        return totalNumberOfTicketsRequested <= MAXIMUM_NUM_OF_PURCHASABLE_TICKETS ? Boolean.TRUE : Boolean.FALSE;
    }
}
