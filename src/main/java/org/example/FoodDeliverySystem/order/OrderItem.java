package org.example.FoodDeliverySystem.order;

public class OrderItem {
    private String food;
    private int quantity;
    private double price;

    public OrderItem(String food, int quantity, double price) {
        this.food = food;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItem() {
        return food;
    }

    public void setItem(String item) {
        this.food = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
