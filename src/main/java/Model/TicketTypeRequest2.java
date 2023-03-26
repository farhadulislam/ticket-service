package Model;


public class TicketTypeRequest2 {

    private final int noOfTickets;
    private final Type type;

    public TicketTypeRequest2(Type type, int noOfTickets) {
        this.type = type;
        this.noOfTickets = noOfTickets;
    }

    private int getNoOfTickets() {
        return noOfTickets;
    }

    public Type getTicketType() {
        return type;
    }

    public enum Type {
        ADULT, CHILD , INFANT
    }

}
