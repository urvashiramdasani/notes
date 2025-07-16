package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class Sparrow extends Bird {
    public Sparrow() {
        super(new CanFly());
    }
}
