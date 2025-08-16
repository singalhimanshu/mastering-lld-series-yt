package org.example;

import java.util.Map;

public class PricingPolicy {
    private final Map<VehicleType, Map<Integer, Double>> rateCard;

    public PricingPolicy(final Map<VehicleType, Map<Integer, Double>> rateCard) {
        this.rateCard = rateCard;
    }

    public double calculate(final Ticket ticket) {
        final long durationInHours = ticket.getDurationInHours();
        final Map<Integer, Double> rates = rateCard.get(ticket.vehicle().getVehicleType());
        return rates.get(1) + (Math.max(0, durationInHours - 1) * rates.get(-1));
    }
}
