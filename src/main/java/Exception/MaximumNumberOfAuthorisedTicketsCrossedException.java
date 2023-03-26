package Exception;

import static Utility.Constants.ErrorMessages.ERROR_MAXIMUM_NUM_OF_TICKETS_ALLOWED;

public class MaximumNumberOfAuthorisedTicketsCrossedException extends RuntimeException{
    public MaximumNumberOfAuthorisedTicketsCrossedException(){
        System.out.println(ERROR_MAXIMUM_NUM_OF_TICKETS_ALLOWED);
    }
}