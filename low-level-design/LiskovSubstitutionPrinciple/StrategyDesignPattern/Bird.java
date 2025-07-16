package LiskovSubstitutionPrinciple.StrategyDesignPattern;

public class Bird {
    private FlyBehavior flyBehavior;

    public Bird(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior newFlyBehavior) {
        this.flyBehavior = newFlyBehavior;
    }

    public void layEggs() {}
    public void eat() {}
}
