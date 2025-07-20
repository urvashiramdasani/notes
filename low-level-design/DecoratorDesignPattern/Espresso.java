package DecoratorDesignPattern;

public class Espresso extends BaseCoffee {
    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public int cost() {
        return 10;
    }
}
