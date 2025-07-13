package LiskovSubstitutionPrinciple.Approach2;

public class Sparrow extends Bird {
    public Sparrow() {
        super(new CanFly());
    }
}
