package DesignRevenueCalculator;

public class Main {
    public static void main(String[] args) {
        long cents = new PromotionalFare(new SurgeFare(new BaseRideFare())).getTotalFare().getCents();
        System.out.println(cents);
    }
}
