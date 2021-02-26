package ood.parkinglot.terminal;

import ood.parkinglot.ParkingSpot;

public interface ParkingAssignmentStrategy {
    ParkingSpot getParkingSpot(Terminal terminal);
    void releaseParkingSpot(ParkingSpot parkingSpot);
}
