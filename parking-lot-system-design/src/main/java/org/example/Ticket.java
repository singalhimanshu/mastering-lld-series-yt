package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public record Ticket(String id, Vehicle vehicle, ParkingSpot spot, Level level, LocalDateTime entryTime) {
    public long getDurationInHours() {
        return Duration.between(entryTime, LocalDateTime.now()).toHours();
    }
}
