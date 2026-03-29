package DesignRevenueCalculator;

import java.util.UUID;

public class RideDetails {
    private final String rideId;
    private final RideType rideType;
    private final String source;
    private final String destination;
    private final int distance;

    public RideDetails(RideType rideType, String source, String destination, int distance) {
        this.rideId = UUID.randomUUID().toString();
        this.rideType = rideType;
        this.destination = destination;
        this.source = source;
        this.distance = distance;
    }

    public String getRideId() {
        return this.rideId;
    }

    public RideType getRideType() {
        return this.rideType;
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getDistance() {
        return this.distance;
    }
}
