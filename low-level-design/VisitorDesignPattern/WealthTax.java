package VisitorDesignPattern;

public class WealthTax implements TaxRuleVisitor {
    @Override
    public void visit(RealEstate realEstate) {
        System.out.println("Wealth tax calculation for real estate...");
    }

    @Override
    public void visit(Stock stock) {
        System.out.println("Wealth tax calculation for stock...");
    }
}
