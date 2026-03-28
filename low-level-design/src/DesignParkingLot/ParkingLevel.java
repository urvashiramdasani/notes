package DesignParkingLot;

import java.util.*;

public class ParkingLevel {
    private final int level;
    private final Map<SpotType, Queue<ParkingSpot>> parkingSpots;
    private final SpotAllocationStrategy allocationStrategy;

    public ParkingLevel(int level, SpotAllocationStrategy allocationStrategy) {
        this.level = level;
        parkingSpots = new HashMap<>();
        this.allocationStrategy = allocationStrategy;
    }

    public int getLevel() {
        return this.level;
    }

    public ParkingSpot findAndPark(Vehicle vehicle) {
        // 1. Get the list of spots this specific vehicle is allowed to park in
        List<SpotType> preferredSpots = this.allocationStrategy.getPreferredSpots(vehicle.getVehicleType());

        // 2. Try them in order of preference (Best-Fit Strategy)
        for (SpotType spotType : preferredSpots) {
            Queue<ParkingSpot> queue = parkingSpots.get(spotType);

            if (queue != null && !queue.isEmpty()) {
                // We found a spot! Remove it from the free pool (O(1))
                ParkingSpot availableSpot = queue.poll();

                // Park the vehicle in the spot
                availableSpot.park(vehicle);

                return availableSpot; // Return the successfully booked spot
            }
        }

        // 3. Lot is completely full for this type of vehicle
        return null;
    }

    public void addFreeSpot(ParkingSpot spot) {
        parkingSpots.putIfAbsent(spot.getSpotType(), new LinkedList<>());
        parkingSpots.get(spot.getSpotType()).offer(spot);
    }

    public void freeSpot(ParkingSpot spot) {
        spot.unpark();
        // Put it back in the queue of available spots
        addFreeSpot(spot);
    }
}
