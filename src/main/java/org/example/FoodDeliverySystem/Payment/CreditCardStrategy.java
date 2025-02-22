package org.example.FoodDeliverySystem.Payment;

public class CreditCardStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Payment is done in credit");
        return true;
    }
}
