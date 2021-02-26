package ood.parkinglot.terminal;

import ood.parkinglot.ParkingSpot;

public class EntryTerminal extends Terminal{

    public Ticket getTicket(ParkingSpot parkingSpot){
        return new ParkingTicket();
    }
}
