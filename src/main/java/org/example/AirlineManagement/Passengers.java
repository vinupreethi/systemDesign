package org.example.AirlineManagement;

import org.example.AirlineManagement.payment.BalanceInsuffice;
import org.example.AirlineManagement.payment.PaymentContext;
import org.example.AirlineManagement.payment.PaymentStrategy;

import java.util.List;

public class Passengers implements Observer {
    private String username;
    private String password;
    private List<Booking> bookingList;
    private List<Baggage> baggage;
    private PaymentContext paymentContext;

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    public PaymentContext getPaymentContext() {
        return paymentContext;
    }

    public void setPaymentContext(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean makePayment(double price, PaymentStrategy paymentStrategy) throws BalanceInsuffice {
        paymentContext = new PaymentContext(paymentStrategy);
        if (paymentContext.makePayment(price))
            return true;
        else
            return false;
    }

    @Override
    public void updateBooking(Booking booking) {
        booking.setBookingStatus(BookingStatus.CANCELLED);
    }
}
