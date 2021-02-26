package ood.parkinglot.terminal;

import ood.parkinglot.ParkingSpot;

import java.time.LocalDateTime;

public class ParkingTicket extends Ticket{
    private ParkingSpot parkingSpot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
