package org.example.FoodDeliverySystem.status;

public class Unavailable implements Status{
    @Override
    public String getStatus() {
        return "Unavailable";
    }
}
