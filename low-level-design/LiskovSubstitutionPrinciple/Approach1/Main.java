package LiskovSubstitutionPrinciple.Approach1;

public class Main {
    public static void main(String[] args) {
        FlyingBird sparrow = new Sparrow();
        sparrow.fly();
        NonFlyingBird penguin = new Penguin();
        // compile time error - penguin.fly();
    }
}
