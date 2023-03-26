package Service;

import Model.TicketTypeRequest;
import ThirdPartyService.SeatReservationServiceImpl;
import ThirdPartyService.TicketPaymentService;
import ThirdPartyService.SeatReservationService;
import ThirdPartyService.TicketPaymentServiceImpl;
import Utility.Constants;

import java.util.Map;
import java.util.stream.Collectors;

import static Utility.Constants.Info.TOTAL_COST;
import static Utility.Constants.Info.TOTAL_SEATS_TO_RESERVE;
import static Utility.TicketRequestValidations.*;


public final class TicketServiceImpl implements TicketService {
    private final TicketPaymentService ticketPaymentService = new TicketPaymentServiceImpl();
    private final SeatReservationService seatReservationService = new SeatReservationServiceImpl();

    @Override
    public void purchaseTickets(Long accountId, Map<TicketTypeRequest, Integer> ticketRequests) {
        Boolean isValidRequest = Boolean.TRUE;
        try {
            isValidRequest = validateTicketRequestIsNotEmpty(ticketRequests) &&
                            validateTicketRequestContainsAdult(ticketRequests) &&
                            validateTotalNumOfTicketsNotMoreThanTwenty(ticketRequests);

        }catch (Exception e){
            System.out.println(Constants.ErrorMessages.ERROR_GENERIC_ERROR);
        }

        // Call the third-party or external services
        if (isValidRequest){
            ticketPaymentService.makePayment(accountId, getTotalCost(ticketRequests));
            seatReservationService.reserveSeat(accountId, getTotalNumberOfSeatsRequired(ticketRequests));
        }
    }


    private int getTotalCost (Map<TicketTypeRequest, Integer> ticketRequests){

        int totalTicketCost = 0;

        for (Map.Entry<TicketTypeRequest, Integer> entry : ticketRequests.entrySet()) {
            if(entry.getKey().equals(TicketTypeRequest.ADULT)){
                int adultTicketCosts = Constants.TicketCost.TWENTY * entry.getValue();
                totalTicketCost += adultTicketCosts;
            } else if (entry.getKey().equals(TicketTypeRequest.CHILD)) {
                int childTicketCosts = Constants.TicketCost.TEN * entry.getValue();
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
       int totalSeatsRequired = ticketRequests
                .entrySet()
                .stream()
                .filter(x -> !TicketTypeRequest.INFANT.equals(x.getKey()))
                .map(x->x.getValue())
                .reduce(0, Integer::sum);
        System.out.println(String.format(TOTAL_SEATS_TO_RESERVE, totalSeatsRequired));

        return  totalSeatsRequired;
    }

}


