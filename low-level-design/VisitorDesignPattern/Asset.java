package VisitorDesignPattern;

public interface Asset {
    void accept(TaxRuleVisitor visitor);
}
