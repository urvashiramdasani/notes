package LiskovSubstitutionPrinciple.Approach2;

public class Penguin extends Bird {
    public Penguin() {
        super(new CannotFly());
    }
}
