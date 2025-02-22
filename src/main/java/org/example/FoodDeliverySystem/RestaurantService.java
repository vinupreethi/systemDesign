package org.example.FoodDeliverySystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantService {
    private List<MenuItem> menuItem;

    public RestaurantService() {
        menuItem = new ArrayList<>();
        initializeRestaurant();
    }

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }

    public void initializeRestaurant() {
        MenuItem menuItem = new MenuItem("Veg fried rice", 124, 1, true, "Vegetable fried rice", 3);
        MenuItem menuItem1 = new MenuItem("Non veg fried rice", 125, 2, true, "Vegetable fried rice", 4);
        MenuItem menuItem2 = new MenuItem("Paneer butter masala", 124, 3, true, "Vegetable fried rice", 4);
        MenuItem menuItem3 = new MenuItem("Chapathi", 124, 4, true, "Vegetable fried rice", 6);
        MenuItem menuItem4 = new MenuItem("Naan", 124, 5, true, "Vegetable fried rice", 1);
        setMenuItem(new ArrayList<>(Arrays.asList(menuItem, menuItem1, menuItem2, menuItem3, menuItem4)));
    }

    public void removeItemInRestaurant(MenuItem menu) {
        menuItem.remove(menu);
    }

    public void addItemFromRestaurant(MenuItem menu)
    {
        menuItem.add(menu);
    }
}
