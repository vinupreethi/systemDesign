package org.example.FoodDeliverySystem;

public class NotEnoughQuantityException extends Throwable {
    public NotEnoughQuantityException(String notEnoughQuantityException) {
        super(notEnoughQuantityException);
    }
}
