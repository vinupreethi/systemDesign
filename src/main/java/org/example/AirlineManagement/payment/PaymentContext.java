package org.example.AirlineManagement.payment;

public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean makePayment(double price) throws BalanceInsuffice {
        return paymentStrategy.makePayment(price);
    }


}
