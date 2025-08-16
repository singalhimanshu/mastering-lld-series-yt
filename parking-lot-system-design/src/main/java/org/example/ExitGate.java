package org.example;

public class ExitGate {
    private final String id;
    private final ParkingLot parkingLot;

    public ExitGate(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public PaymentReceipt processTicket(final Ticket ticket, final PaymentType paymentType) {
        final PaymentReceipt paymentReceipt = parkingLot.unassign(ticket, paymentType);
        System.out.println("Payment of " + paymentReceipt.amount() + " done via: " + paymentType + " on: " + paymentReceipt.timestamp());
        return paymentReceipt;
    }
}
