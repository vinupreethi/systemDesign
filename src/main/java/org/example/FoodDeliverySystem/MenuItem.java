package org.example.FoodDeliverySystem;

public class MenuItem {
    private String foodName;
    private String description;
    private double price;
    private int foodId;
    private boolean isAvailable;
    private double quantity;


    public MenuItem(String foodName, double price, int foodId, boolean isAvailable, String description,double quantity) {
        this.foodName = foodName;
        this.price = price;
        this.foodId = foodId;
        this.isAvailable = isAvailable;
        this.description = description;
        this.quantity=quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
