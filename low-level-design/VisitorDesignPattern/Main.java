package VisitorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Asset realEstate = new RealEstate();
        Asset stock = new Stock();

        realEstate.accept(new StateTax());
        stock.accept(new WealthTax());
    }
}
