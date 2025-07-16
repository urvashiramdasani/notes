package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cannot fly...");
    }
}
