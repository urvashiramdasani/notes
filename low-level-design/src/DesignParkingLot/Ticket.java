package DesignParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ParkingSpot getSpot() {
        return this.spot;
    }

    public LocalDateTime getEntryTime() {
        return this.entryTime;
    }
}
