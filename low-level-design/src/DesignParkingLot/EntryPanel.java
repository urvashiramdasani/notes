package DesignParkingLot;

public class EntryPanel {
    private final ParkingLot parkingLot;

    public EntryPanel(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket issueTicket(Vehicle vehicle) {
        // 1. Ask the lot to find a spot and park the car
        ParkingSpot securedSpot = parkingLot.getSpotAndPark(vehicle);

        // 2. Handle the result
        if (securedSpot == null) {
            return null;
        }

        // 3. Create and return the ticket
        return new Ticket(vehicle, securedSpot);
    }
}
