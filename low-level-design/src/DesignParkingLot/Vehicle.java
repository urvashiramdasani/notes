package DesignParkingLot;

import java.util.UUID;

public abstract class Vehicle {
    private final String vehicleId;
    private final VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleId = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
