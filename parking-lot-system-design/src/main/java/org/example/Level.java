package org.example;

import java.util.*;

public class Level {
    private final Integer floorNumber;
    private final Map<ParkingSpotType, List<ParkingSpot>> spots;
    private final DisplayBoard displayBoard;

    public Level(final Integer floorNumber, final DisplayBoard board) {
        this.floorNumber = floorNumber;
        this.spots = new HashMap<>();
        this.displayBoard = board;
    }

    public void addSpot(final ParkingSpot parkingSpot) {
        this.spots.computeIfAbsent(parkingSpot.getType(), k -> new ArrayList<>()).add(parkingSpot);
    }

    public boolean isFull() {
        return spots.values().stream().flatMap(List::stream).noneMatch(ParkingSpot::isFree);
    }

    public Ticket parkVehicle(final Vehicle vehicle) {
        for (ParkingSpotType type: ParkingSpotType.values()) {
            for (ParkingSpot spot : spots.get(type)) {
                if (spot.isFree() && spot.canFit(vehicle)) {
                    final Ticket ticket = spot.assign(vehicle, this);
                    updateBoard();
                    return ticket;
                }
            }
        }
        return null;
    }

    public void updateBoard() {
        displayBoard.update(spots);
    }
}
