package org.example.AirlineManagement.payment;

public interface PaymentStrategy {
     boolean makePayment(double price) throws BalanceInsuffice;
}
