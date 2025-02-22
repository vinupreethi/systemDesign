package org.example.FoodDeliverySystem;

import org.example.FoodDeliverySystem.status.Status;

public class DeliveryAgents extends Person {
    private String password;
    private Status availabityStatus;

    public Status getAvailabityStatus() {
        return availabityStatus;
    }

    public void setAvailabityStatus(Status availabityStatus) {
        this.availabityStatus = availabityStatus;
    }

    public DeliveryAgents(String name, Location address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
