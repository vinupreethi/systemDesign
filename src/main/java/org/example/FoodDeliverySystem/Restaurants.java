package org.example.FoodDeliverySystem;

public class Restaurants {
    private String restaurantName;
    private RestaurantService restaurantService;
    private Location location;

    public Restaurants(String restaurantName, RestaurantService restaurantService, Location location) {
        this.restaurantName = restaurantName;
        this.restaurantService = restaurantService;
        this.location=location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}
