package DecoratorDesignPattern;

public class Latte extends BaseCoffee {
    public String description() {
        return "Latte";
    }

    @Override
    int cost() {
        return 15;
    }
}
