package DesignParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INITIALIZING UBER HUB PARKING LOT ---\n");

        // 1. Define the Global Rulebook (Strategy)
        SpotAllocationStrategy standardRules = new StandardAllocationStrategy();

        // 2. Build the Levels
        List<ParkingLevel> levels = new ArrayList<>();

        // Level 1: 1 Compact Spot, 1 Large Spot
        ParkingLevel level1 = new ParkingLevel(1, standardRules);
        level1.addFreeSpot(new ParkingSpot(SpotType.COMPACT, 1));
        level1.addFreeSpot(new ParkingSpot(SpotType.LARGE, 1));
        levels.add(level1);

        // Level 2: 1 Motorcycle Spot
        ParkingLevel level2 = new ParkingLevel(2, standardRules);
        level2.addFreeSpot(new ParkingSpot(SpotType.MOTORCYCLE, 2));
        levels.add(level2);

        // 3. Initialize the Central Coordinator (The Facade)
        ParkingLot centralLot = new ParkingLot(levels);

        // 4. Initialize the Panels
        EntryPanel mainEntrance = new EntryPanel(centralLot);
        ExitPanel mainExit = new ExitPanel(centralLot);

        // 5. Create some test vehicles
        Vehicle myCar = new Car();
        Vehicle myBike = new Motorcycle();
        Vehicle giantTruck = new Truck();
        Vehicle secondCar = new Car();

        System.out.println("\n--- TESTING ARRIVALS ---");

        // Car 1 arrives (Should take L1-C1)
        Ticket ticket1 = mainEntrance.issueTicket(myCar);

        // Bike arrives (Should take L2-M1 because of Best-Fit rule)
        Ticket ticket2 = mainEntrance.issueTicket(myBike);

        // Truck arrives (Should take L1-L1)
        Ticket ticket3 = mainEntrance.issueTicket(giantTruck);

        // Car 2 arrives (Should fail! Compact is taken by Car 1, Large is taken by Truck)
        Ticket ticket4 = mainEntrance.issueTicket(secondCar);


        System.out.println("\n--- TESTING DEPARTURES ---");

        // Car 1 leaves
        if (ticket1 != null) {
            mainExit.processExit(ticket1);
        }

        System.out.println("\n--- TESTING RE-ALLOCATION ---");

        // Car 2 tries again now that Car 1 left (Should take L1-C1)
        Ticket ticket5 = mainEntrance.issueTicket(secondCar);
    }
}
