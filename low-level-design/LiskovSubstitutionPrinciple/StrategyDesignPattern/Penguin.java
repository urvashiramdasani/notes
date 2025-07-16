package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class Penguin extends Bird {
    public Penguin() {
        super(new CannotFly());
    }
}
