package DesignParkingLot;

import java.util.Arrays;
import java.util.List;

// The Standard Rules
public class StandardAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public List<SpotType> getPreferredSpots(VehicleType type) {
        return switch (type) {
            case MOTORCYCLE -> Arrays.asList(SpotType.MOTORCYCLE, SpotType.COMPACT, SpotType.LARGE);
            case CAR -> Arrays.asList(SpotType.COMPACT, SpotType.LARGE);
            case TRUCK -> List.of(SpotType.LARGE);
        };
    }
}
