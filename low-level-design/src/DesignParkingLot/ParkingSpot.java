package DesignParkingLot;

import java.util.UUID;

public class ParkingSpot {
    private final SpotType spotType;
    private final String spotId;
    private Vehicle currentVehicle;
    private final int levelNumber;

    public ParkingSpot(SpotType spotType, int levelNumber) {
        this.spotType = spotType;
        this.spotId = UUID.randomUUID().toString();
        this.levelNumber = levelNumber;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    public String getSpotId() {
        return this.spotId;
    }

    public Vehicle getCurrentVehicle() {
        return this.currentVehicle;
    }

    public int getLevelNumber() {
        return this.levelNumber;
    }

    public void park(Vehicle vehicle) {
        this.currentVehicle = vehicle;
    }

    public void unpark() {
        this.currentVehicle = null;
    }
}
