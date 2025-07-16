package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class CanFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}
