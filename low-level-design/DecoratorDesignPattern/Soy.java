package DecoratorDesignPattern;

public class Soy extends AddonDecorator {
    public Soy(BaseCoffee baseCoffee) {
        this.baseCoffee = baseCoffee;
    }

    @Override
    String description() {
        return this.baseCoffee.description() + " with soy";
    }

    @Override
    int cost() {
        return this.baseCoffee.cost() + 20;
    }
}
