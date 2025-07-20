package DecoratorDesignPattern;

public class Caramel extends AddonDecorator {
    public Caramel(BaseCoffee baseCoffee) {
        this.baseCoffee = baseCoffee;
    }

    @Override
    String description() {
        return this.baseCoffee.description() + " with caramel";
    }

    @Override
    int cost() {
        return this.baseCoffee.cost() + 25;
    }
}
