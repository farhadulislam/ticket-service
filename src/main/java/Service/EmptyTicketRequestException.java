package Service;

import static Utility.Constants.ErrorMessages.ERROR_EMPTY_TICKET_REQUEST;

public class EmptyTicketRequestException extends RuntimeException{
    public EmptyTicketRequestException(){
        System.out.println(ERROR_EMPTY_TICKET_REQUEST);
    }
}
