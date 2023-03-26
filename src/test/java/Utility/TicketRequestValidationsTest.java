package Utility;

import Model.TicketTypeRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static Utility.Constants.ErrorMessages.ERROR_EMPTY_TICKET_REQUEST;
import static Utility.Constants.ErrorMessages.ERROR_TICKET_REQUEST_NULL;
import static org.junit.jupiter.api.Assertions.*;

class TicketRequestValidationsTest {
    private final Map<TicketTypeRequest, Integer> ticketRequestsTestObj = new HashMap<>();
    @BeforeEach
    void setUp() {

        ticketRequestsTestObj.put(TicketTypeRequest.ADULT, 15);
        ticketRequestsTestObj.put(TicketTypeRequest.CHILD, 1);
        ticketRequestsTestObj.put(TicketTypeRequest.INFANT, 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateTicketRequestContainsAdult() {
        assertFalse((!ticketRequestsTestObj.containsKey(TicketTypeRequest.ADULT) && ticketRequestsTestObj.get(TicketTypeRequest.ADULT).equals(0)));
    }

    @Test
    void validateTicketRequestIsNotNull() {
        assertTrue(null != ticketRequestsTestObj, ERROR_TICKET_REQUEST_NULL);
    }
    @Test
    void validateTicketRequestIsNotEmpty() {
        assertTrue(!ticketRequestsTestObj.isEmpty(), ERROR_EMPTY_TICKET_REQUEST);
    }

    @Test
    void validateTotalNumOfTicketsNotMoreThanTwenty() {
        int totalNumberOfTicketsRequested = ticketRequestsTestObj.
                 values()
                .stream()
                .reduce(0, Integer::sum);
        //assertThat(T actual, Matcher<T> matcher)
        assertTrue(totalNumberOfTicketsRequested <=20);


    }
}