package Model;

import static Utility.Constants.TicketCost.*;
import static Utility.Constants.TicketType.*;

public enum TicketTypeRequest {

    INFANT(INFANT_TICKET, ZERO),
    CHILD(CHILD_TICKET, TEN),
    ADULT(ADULT_TICKET, TWENTY);

    private final String ticketType;
    private final Integer cost;

    TicketTypeRequest(String ticketType, Integer cost) {
        this.ticketType = ticketType;
        this.cost = cost;
    }
    public String getTicketType() {
        return ticketType;
    }

    public Integer getCost() {
        return cost;
    }




}
