package org.example.FoodDeliverySystem;


import org.example.FoodDeliverySystem.Payment.PaymentContext;
import org.example.FoodDeliverySystem.Payment.PaymentStrategy;

public class Customer extends Person{
    private String password;
    private PaymentContext paymentContext;

    public Customer(String name, Location address, String phoneNumber) {
        super(name, address, phoneNumber);

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean makePayment(PaymentStrategy paymentStrategy,double amount) {
        paymentContext=new PaymentContext(paymentStrategy);
        paymentContext.makePayment(amount);
        return true;
    }
}
