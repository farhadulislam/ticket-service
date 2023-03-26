package Service;

import static Utility.Constants.ErrorMessages.ERROR_AN_ADULT_TICKET_MUST_BE_PRESENT;

public class AdultTicketAbsentException extends RuntimeException {
    public AdultTicketAbsentException(){
        System.out.println(ERROR_AN_ADULT_TICKET_MUST_BE_PRESENT);
    }
}
