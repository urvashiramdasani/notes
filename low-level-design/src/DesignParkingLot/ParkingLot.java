package DesignParkingLot;

import java.util.List;

public class ParkingLot {
    private final List<ParkingLevel> levels;

    public ParkingLot(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    // The Coordinator Method
    public ParkingSpot getSpotAndPark(Vehicle vehicle) {
        // Iterate through levels to find a spot
        for (ParkingLevel level : levels) {
            ParkingSpot spot = level.findAndPark(vehicle);
            if (spot != null) {
                // Spot found and vehicle is already parked in it by the Level!
                return spot;
            }
        }
        // Lot is completely full for this vehicle type
        return null;
    }

    public void freeSpot(ParkingSpot spot) {
        for (ParkingLevel level : levels) {
            if (level.getLevel() == spot.getLevelNumber()) {
                level.freeSpot(spot);
                return;
            }
        }
    }
}
