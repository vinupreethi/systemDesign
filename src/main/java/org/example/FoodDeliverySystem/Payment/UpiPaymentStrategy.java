package org.example.FoodDeliverySystem.Payment;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Payment is done in UPI ");
        return true;
    }
}
