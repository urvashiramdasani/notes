package DesignParkingLot;

public class ExitPanel {
    private final ParkingLot parkingLot;

    public ExitPanel(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public double processExit(Ticket ticket) {
        // 1. Calculate fee (Simulating 2 hours for the test)
        double hourlyRate = 5.0; // use strategy pattern for pricing
        double fee = 2 * hourlyRate;

        // 2. Tell the central system to free the spot
        parkingLot.freeSpot(ticket.getSpot());

        return fee;
    }
}