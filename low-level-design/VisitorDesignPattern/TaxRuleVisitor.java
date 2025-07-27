package VisitorDesignPattern;

public interface TaxRuleVisitor {
    void visit(RealEstate realEstate);
    void visit(Stock stock);
}
