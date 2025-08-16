package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private final Map<ParkingSpotType, Integer> availableSpots;

    public DisplayBoard() {
        this.availableSpots = new HashMap<>();
    }


    public void update(final Map<ParkingSpotType, List<ParkingSpot>> spots) {
        for (ParkingSpotType parkingSpotType : spots.keySet()) {
            final int available = (int) spots.get(parkingSpotType).stream()
                    .filter(ParkingSpot::isFree)
                    .count();
            availableSpots.put(parkingSpotType, available);
        }
        print();
    }

    public void print() {
        System.out.println("Display board status:");
        boolean full = true;
        for (Map.Entry<ParkingSpotType, Integer> entry: availableSpots.entrySet()) {
            int count = entry.getValue();
            System.out.printf(" - %s: %d spots available", entry.getKey(), count);
            if (count > 0) full = false;
        }
        if (full) {
            System.out.println("This level is full");
        }
        System.out.println();
    }
}
