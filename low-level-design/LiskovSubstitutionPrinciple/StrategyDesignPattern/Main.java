package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        sparrow.fly();

        sparrow.setFlyBehavior(new CannotFly());
        sparrow.fly();
    }
}
