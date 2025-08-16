package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingSpot {
    private final String id;
    private Boolean free;
    private final ParkingSpotType type;
    private Vehicle vehicle;

    public ParkingSpot(String id, ParkingSpotType type) {
        this.id = id;
        this.type = type;
        this.free = true;
    }

    public boolean canFit(final Vehicle vehicle) {
        return (VehicleType.CAR.equals(vehicle.getVehicleType()) && ParkingSpotType.COMPACT.equals(type)) ||
                (VehicleType.MOTORCYCLE.equals(vehicle.getVehicleType()) && ParkingSpotType.MOTORCYCLE.equals(type)) ||
                (VehicleType.VAN.equals(vehicle.getVehicleType()) && ParkingSpotType.LARGE.equals(type)) ||
                (VehicleType.TRUCK.equals(vehicle.getVehicleType()) && ParkingSpotType.LARGE.equals(type));
    }

    public Ticket assign(final Vehicle vehicle, final Level level) {
        this.vehicle = vehicle;
        this.free = false;
        return new Ticket(UUID.randomUUID().toString(), vehicle, this, level, LocalDateTime.now());
    }

    public void unassing() {
        this.vehicle = null;
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }

    public ParkingSpotType getType() {
        return this.type;
    }
}
