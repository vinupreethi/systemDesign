package org.example.FoodDeliverySystem.order;

import org.example.FoodDeliverySystem.Customer;
import org.example.FoodDeliverySystem.DeliveryAgents;

import java.util.List;

public class Order {
    private double amount;
    private Customer customer;
    private List<OrderItem> foods;
    private OrderStatus status;
    private DeliveryAgents deliveryAgent;


    public List<OrderItem> getFoods() {
        return foods;
    }

    public void setFoods(List<OrderItem> foods) {
        this.foods = foods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public DeliveryAgents getDeliveryAgent() {
        return deliveryAgent;
    }

    public void setDeliveryAgent(DeliveryAgents deliveryAgent) {
        this.deliveryAgent = deliveryAgent;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
