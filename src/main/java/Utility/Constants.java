package Utility;

public class Constants {
    public static final class TicketType {
        public static final String INFANT_TICKET = "INFANT TICKET";
        public static final String CHILD_TICKET = "CHILD TICKET";
        public static final String ADULT_TICKET = "ADULT TICKET";
    }

    public static final class TicketCost{

        public static final Integer ZERO = 0;
        public static final Integer TEN = 10;
        public static final Integer TWENTY = 20;

    }

    public static final class Constraint{
        public static final Integer MAXIMUM_NUM_OF_PURCHASABLE_TICKETS = 20;

    }
    public static final class ErrorMessages{

        public static final String ERROR_AN_ADULT_TICKET_MUST_BE_PRESENT = "Error! No adult ticket selected.";
        public static final String ERROR_MAXIMUM_NUM_OF_TICKETS_ALLOWED = "Error! A maximum of 20 tickets can be purchase at a given time.";
        public static final String ERROR_EMPTY_TICKET_REQUEST = "Error!Ticket request can't be empty.";
        public static final String ERROR_TICKET_REQUEST_NULL = "Error!Ticket request must be initialized or not null.";
        public static final String ERROR_GENERIC_ERROR = "Error! An error has occurred.";
        public static final String ERROR_INVALID_REQUEST = "Failed to book! Invalid request made.";

    }

    public static final class Info{
        public static final String TOTAL_COST = "TOTAL COST: %s ";
        public static final String TOTAL_SEATS_TO_ALLOCATE = "TOTAL SEATS TO ALLOCATE: %d ";

    }

}
