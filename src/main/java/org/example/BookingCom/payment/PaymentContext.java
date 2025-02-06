package org.example.BookingCom.payment;

public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double price) {
        paymentStrategy.makePayment(price);
    }
}
