package org.example.FoodDeliverySystem;

public class OrderNotCreatedException extends Throwable {
    public OrderNotCreatedException(String msg) {
        super(msg);
    }
}
