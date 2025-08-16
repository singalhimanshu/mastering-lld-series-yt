package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ParkingLot {
    private final List<Level> levels;
    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;
    private final PricingPolicy pricingPolicy;
    private static ParkingLot instance;

    public ParkingLot(final PricingPolicy pricingPolicy) {
        this.levels = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.pricingPolicy = pricingPolicy;
    }

    public boolean isFull() {
        return levels.stream().allMatch(Level::isFull);
    }

    public Ticket assignSpot(final Vehicle vehicle) {
        final Optional<Level> maybeLevel = levels.stream().filter(level -> !level.isFull()).findFirst();
        if (maybeLevel.isEmpty()) {
            throw new IllegalStateException("all levels are full");
        }
        return maybeLevel.get().parkVehicle(vehicle);
    }

    public PaymentReceipt unassign(final Ticket ticket, final PaymentType paymentType) {
        final double price = pricingPolicy.calculate(ticket);
        PaymentReceipt paymentReceipt = new PaymentReceipt(UUID.randomUUID().toString(), price, LocalDateTime.now(), paymentType);
        ticket.spot().unassing();
        ticket.level().updateBoard();
        return paymentReceipt;
    }

    public void addEntryGate(final EntryGate entryGate) {
        this.entryGates.add(entryGate);
    }

    public void addExitGate(final ExitGate exitGate) {
        this.exitGates.add(exitGate);
    }

    public void addLevel(final Level level) {
        this.levels.add(level);
    }
}
