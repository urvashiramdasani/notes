package VisitorDesignPattern;

public class StateTax implements TaxRuleVisitor {
    @Override
    public void visit(RealEstate realEstate) {
        System.out.println("State tax calculation for real estate...");
    }

    @Override
    public void visit(Stock stock) {
        System.out.println("State tax calculation for stock...");
    }
}
