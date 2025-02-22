package org.example.FoodDeliverySystem.Payment;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean makePayment(double amount) {
        return paymentStrategy.makePayment(amount);
    }
}
