package Service;

import Model.TicketTypeRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceImplTest {

    private final Map<TicketTypeRequest, Integer> ticketRequestsTestObj = new HashMap<>();
    private final TicketService ticketServiceTestObj = new TicketServiceImpl();
    @BeforeEach
    void setUp() {

        ticketRequestsTestObj.put(TicketTypeRequest.ADULT, 1);
        ticketRequestsTestObj.put(TicketTypeRequest.CHILD, 2);
        ticketRequestsTestObj.put(TicketTypeRequest.INFANT, 3);
    }

    @AfterEach
    void tearDown() {
        //Impl
    }

    @Test
    void purchaseTickets() {
        //Impl
    }

    @Test
    void getTotalCostTest(){
       /* Access modifier of actual method getTotalCost(arg) needs to be protected (package private)
        as opposed to what now private as per requirement.
        It can then be tested.*/
    }

}