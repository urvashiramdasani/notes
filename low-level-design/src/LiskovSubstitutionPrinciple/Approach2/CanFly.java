package LiskovSubstitutionPrinciple.Approach2;

public class CanFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}
