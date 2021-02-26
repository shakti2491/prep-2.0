package ood.parkinglot.terminal;

public class ExitTerminal extends Terminal {
    public ParkingTicket pay(ParkingTicket ticket, PaymentStrategy paymentStrategy){
        return new ParkingTicket();
    }
}
