package org.example.BookingCom;

import org.example.BookingCom.payment.PaymentContext;
import org.example.BookingCom.payment.PaymentStrategy;

public class Customer {
    private Planner planner;
    private String name;
    private String phoneNo;
    private String emailId;
    private PaymentContext paymentContext;

    public Customer(String name, String phoneNo, String emailId) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public Planner getPlanner() {
        return planner;
    }

    public void setPlanner(Planner planner) {
        this.planner = planner;
    }

    public void makePayment(PaymentStrategy paymentStrategy,double price) {
        paymentContext=new PaymentContext(paymentStrategy);
        paymentContext.makePayment(price);
    }
}
