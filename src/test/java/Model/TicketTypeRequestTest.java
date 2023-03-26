package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static Model.TicketTypeRequest.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketTypeRequestTest {

    private final Map<TicketTypeRequest, Integer> ticketRequestsTestObj = new HashMap<>();
    @BeforeEach
    void setUp() {

        ticketRequestsTestObj.put(ADULT, 1);
        ticketRequestsTestObj.put(CHILD, 1);
        ticketRequestsTestObj.put(INFANT, 1);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getCostTest() {
        assertTrue(ADULT.getCost().equals(20));
        assertTrue(CHILD.getCost().equals(10));
        assertTrue(INFANT.getCost().equals(0));
    }
}