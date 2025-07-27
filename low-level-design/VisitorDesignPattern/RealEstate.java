package VisitorDesignPattern;

public class RealEstate implements Asset {
    @Override
    public void accept(TaxRuleVisitor visitor) {
        visitor.visit(this);
    }
}
