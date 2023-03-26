package Service;

import Model.TicketTypeRequest;
import ThirdPartyService.SeatReservationServiceImpl;
import ThirdPartyService.TicketPaymentService;
import ThirdPartyService.SeatReservationService;
import ThirdPartyService.TicketPaymentServiceImpl;
import Utility.Constants;

import java.util.Map;

import static Utility.Constants.ErrorMessages.ERROR_GENERIC_ERROR;
import static Utility.Constants.ErrorMessages.ERROR_INVALID_REQUEST;
import static Utility.Constants.Info.TOTAL_COST;
import static Utility.Constants.Info.TOTAL_SEATS_TO_ALLOCATE;
import static Utility.TicketRequestValidations.*;


public final class TicketServiceImpl implements TicketService {
    private final TicketPaymentService ticketPaymentService = new TicketPaymentServiceImpl();
    private final SeatReservationService seatReservationService = new SeatReservationServiceImpl();

    @Override
    public void purchaseTickets(Long accountId, Map<TicketTypeRequest, Integer> ticketRequests) {

        Boolean isValidRequest = Boolean.FALSE;

        //Validate request first before proceeding onto payment and reservation.
        try {
            isValidRequest = validateTicketRequestIsNotEmpty(ticketRequests) &&
                            validateTicketRequestContainsAdult(ticketRequests) &&
                            validateTotalNumOfTicketsNotMoreThanTwenty(ticketRequests);

        }catch (Exception e){
            //Can be logged onto log-tracing system in lieu of sysout shown below.
            System.out.println(ERROR_GENERIC_ERROR);
        }

        // Call the third-party or external services, once ticket request is validated as per business rules.
        if (isValidRequest){
            ticketPaymentService.makePayment(accountId, getTotalCost(ticketRequests));
            seatReservationService.reserveSeat(accountId, getTotalNumberOfSeatsRequired(ticketRequests));
        } else {
            System.out.println(ERROR_INVALID_REQUEST);
        }
    }

    //Calculate cost and display ( just for clarity).
    private int getTotalCost (Map<TicketTypeRequest, Integer> ticketRequests){

        int totalTicketCost = 0;

        for (Map.Entry<TicketTypeRequest, Integer> entry : ticketRequests.entrySet()) {
            if(entry.getKey().equals(TicketTypeRequest.ADULT)){
                int adultTicketCosts = TicketTypeRequest.ADULT.getCost() * entry.getValue();
                totalTicketCost += adultTicketCosts;
            } else if (entry.getKey().equals(TicketTypeRequest.CHILD)) {
                int childTicketCosts = TicketTypeRequest.CHILD.getCost() * entry.getValue();
                totalTicketCost += childTicketCosts;
            }
        }
        ticketRequests.entrySet().stream().forEach(System.out::println);
        System.out.println(String.format("NUMBER OF TICKETS : %d ", ticketRequests.
                values()
                .stream()
                .reduce(0, Integer::sum)));
        System.out.println(String.format(TOTAL_COST, totalTicketCost));

        return totalTicketCost;
    }
    //Calculate number of seat required for adult and children only since infants will be sitting on lap.
    private int getTotalNumberOfSeatsRequired(Map<TicketTypeRequest, Integer> ticketRequests){
       int totalSeatsToAllocate = ticketRequests
                .entrySet()
                .stream()
                .filter(x -> !TicketTypeRequest.INFANT.equals(x.getKey()))
                .map(x->x.getValue())
                .reduce(0, Integer::sum);
        System.out.println(String.format(TOTAL_SEATS_TO_ALLOCATE, totalSeatsToAllocate));

        return  totalSeatsToAllocate;
    }

}


