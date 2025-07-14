package FactoryDesignPattern;

import java.util.Objects;

public class PaymentFactory {
    public PaymentMethod getPaymentMethod(String value) {
        if(Objects.equals(value, "UPI")) {
            return new UPIMethod();
        } else return new CreditCardMethod();
    }
}
