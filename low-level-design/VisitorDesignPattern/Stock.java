package VisitorDesignPattern;

public class Stock implements Asset {
    @Override
    public void accept(TaxRuleVisitor visitor) {
        visitor.visit(this);
    }
}
