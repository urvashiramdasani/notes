package DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        System.out.println(espresso.description());
        System.out.println(espresso.cost());

        Soy soy = new Soy(new Espresso());
        System.out.println(soy.description());
        System.out.println(soy.cost());

        Caramel caramel = new Caramel(new Soy(new Latte()));
        System.out.println(caramel.description());
        System.out.println(caramel.cost());
    }
}
