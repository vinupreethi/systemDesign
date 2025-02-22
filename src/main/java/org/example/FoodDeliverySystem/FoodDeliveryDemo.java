package org.example.FoodDeliverySystem;


import org.example.FoodDeliverySystem.order.Order;
import org.example.FoodDeliverySystem.order.OrderItem;
import org.example.FoodDeliverySystem.status.AvailabilityStatus;
import org.example.FoodDeliverySystem.status.Unavailable;

import java.util.Arrays;

public class FoodDeliveryDemo {
    public static void main(String args[]) throws NotEnoughQuantityException, OrderNotCreatedException {
        FoodDeliveryService foodDeliveryService = FoodDeliveryService.getInstance();
        Location location = new Location(12, 12);
        Customer customer = new Customer("Vinu", location, "9212341412");
        Customer customer1 = new Customer("Jomo", location, "123123123");
        customer.setPassword("Vinu");
        customer1.setPassword("Jomo");
        foodDeliveryService.registerCustomer(customer);
        foodDeliveryService.registerCustomer(customer1);


        Restaurants restaurant = new Restaurants("Breeze", new RestaurantService(), location);
        Restaurants restaurant1 = new Restaurants("Raja", new RestaurantService(), location);
        foodDeliveryService.registerRestaurant(restaurant);
        foodDeliveryService.registerRestaurant(restaurant1);

        DeliveryAgents deliveryAgents = new DeliveryAgents("shankar", location, "1231412412");
        DeliveryAgents deliveryAgents1 = new DeliveryAgents("Mani", location, "2313123");
        deliveryAgents1.setAvailabityStatus(new Unavailable());
        deliveryAgents.setAvailabityStatus(new AvailabilityStatus());
        foodDeliveryService.registerDeliveryAgents(deliveryAgents);
        foodDeliveryService.registerDeliveryAgents(deliveryAgents1);

        foodDeliveryService.login("Vinu", "Vinu");
        foodDeliveryService.ViewRestaurantsAndMenuItem();

        foodDeliveryService.createOrder(customer1);


    }
}
