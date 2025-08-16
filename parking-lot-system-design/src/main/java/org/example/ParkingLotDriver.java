package org.example;

import java.util.Map;
import java.util.UUID;

public class ParkingLotDriver {
    public static void main(String[] args) {
        final Map<VehicleType, Map<Integer, Double>> rateCard = Map.of(
                VehicleType.CAR, Map.of(1, 30.0, -1, 20.0),
                VehicleType.TRUCK, Map.of(1, 50.0, -1, 40.0),
                VehicleType.MOTORCYCLE, Map.of(1, 10.0, -1, 5.0)
        );
        final PricingPolicy pricingPolicy = new PricingPolicy(rateCard);
        final ParkingLot parkingLot = new ParkingLot(pricingPolicy);
        final EntryGate entryGate1 = new EntryGate(UUID.randomUUID().toString(), parkingLot);
        parkingLot.addEntryGate(entryGate1);
        final EntryGate entryGate2 = new EntryGate(UUID.randomUUID().toString(), parkingLot);
        parkingLot.addEntryGate(entryGate2);
        final ExitGate exitGate1 = new ExitGate(UUID.randomUUID().toString(), parkingLot);
        parkingLot.addExitGate(exitGate1);

        final DisplayBoard displayBoard = new DisplayBoard();

        final Level level1 = new Level(1, displayBoard);
        final ParkingSpot parkingSpot1 = new ParkingSpot(UUID.randomUUID().toString(), ParkingSpotType.ACCESSIBLE);
        level1.addSpot(parkingSpot1);
        final ParkingSpot parkingSpot2 = new ParkingSpot(UUID.randomUUID().toString(), ParkingSpotType.COMPACT);
        level1.addSpot(parkingSpot2);
        final ParkingSpot parkingSpot3 = new ParkingSpot(UUID.randomUUID().toString(), ParkingSpotType.MOTORCYCLE);
        level1.addSpot(parkingSpot3);
        final ParkingSpot parkingSpot4 = new ParkingSpot(UUID.randomUUID().toString(), ParkingSpotType.LARGE);
        level1.addSpot(parkingSpot4);
        level1.updateBoard();
        parkingLot.addLevel(level1);

        final Vehicle car = new Car("123");
        final Ticket ticket = entryGate1.generateTicket(car);
        System.out.println("here's your parking ticket: " + ticket);

        final PaymentReceipt paymentReceipt = exitGate1.processTicket(ticket, PaymentType.CREDIT_CARD);
        System.out.println("payment receipt: " + paymentReceipt);
    }
}