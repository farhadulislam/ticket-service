package ThirdPartyService;

public interface TicketPaymentService {
    public void makePayment(long accountId, int totalAmountToPay);
}
