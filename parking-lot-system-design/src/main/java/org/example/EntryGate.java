package org.example;

public class EntryGate {
    private final String id;
    private final ParkingLot parkingLot;


    public EntryGate(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(final Vehicle vehicle) {
        if (parkingLot.isFull()) {
            throw new IllegalStateException("parking lot is full");
        }
        return parkingLot.assignSpot(vehicle);
    }
}
