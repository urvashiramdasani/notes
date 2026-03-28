package DesignParkingLot;

import java.util.List;

public interface SpotAllocationStrategy {
    // Takes a vehicle type and returns the ordered list of allowed spots
    List<SpotType> getPreferredSpots(VehicleType vehicleType);
}