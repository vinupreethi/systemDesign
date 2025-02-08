package org.example.AirlineManagement.payment;

public class CreditCardStrategy implements PaymentStrategy {

    int balance;

    @Override
    public boolean makePayment(double price) throws BalanceInsuffice {
        if (balance<0) {
            throw new BalanceInsuffice("Balance is insuffice");
        }
        else {
            System.out.println("Paid using Credit card");
        }
        return true;
    }
}
