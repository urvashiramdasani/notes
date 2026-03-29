package DesignRevenueCalculator;

public class Main {
    public static void main(String[] args) {
        long cents = new PromotionalFare(new SurgeFare(new BaseRideFare(
                new RideDetails(RideType.GO, "Panathur", "Indiranagar", 5)
        )), 20).getTotalFare().getCents();
        System.out.println(cents);
    }
}
