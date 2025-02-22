package org.example.FoodDeliverySystem;

import org.example.FoodDeliverySystem.Payment.CreditCardStrategy;
import org.example.FoodDeliverySystem.order.Order;
import org.example.FoodDeliverySystem.order.OrderItem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class FoodDeliveryService {
    public static FoodDeliveryService foodDeliveryService;
    private ConcurrentHashMap<Long, Order> orderMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Restaurants> restaurantMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Customer> customerMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, DeliveryAgents> DeliveryMap = new ConcurrentHashMap<>();
    private static final AtomicLong orderCounter = new AtomicLong(0);
    private static final AtomicLong customerCounter = new AtomicLong(0);
    private static final AtomicLong restaurantCounter = new AtomicLong(0);
    private static final AtomicLong deliveryAgentsCounter = new AtomicLong(0);


    public void setDeliveryMap(ConcurrentHashMap<Long, DeliveryAgents> deliveryMap) {
        DeliveryMap = deliveryMap;
    }

    private FoodDeliveryService() {

    }

    public static FoodDeliveryService getInstance() {
        if (foodDeliveryService == null) {
            synchronized (FoodDeliveryService.class) {
                if (foodDeliveryService == null) {
                    return new FoodDeliveryService();
                }
            }
        }
        return foodDeliveryService;
    }


    public void registerCustomer(Customer customer) {
        long customerId = customerCounter.incrementAndGet();
        customerMap.put(customerId, customer);
    }

    public void registerDeliveryAgents(DeliveryAgents deliveryAgents) {
        long deliveryAgentId = deliveryAgentsCounter.incrementAndGet();
        DeliveryMap.put(deliveryAgentId, deliveryAgents);
    }


    public void createOrder(Customer customer) throws NotEnoughQuantityException, OrderNotCreatedException {
        Order order = new Order();
        order.setCustomer(customer);
        long restaurantId = 1L;
        List<OrderItem> orderItems = getListOfOrderItemFromRestaurant(restaurantId);
        order.setFoods(orderItems);
        double amount = 0;
        for (OrderItem order1 : orderItems) {
            amount += order1.getPrice();
        }
        order.setAmount(amount);
        if (customer.makePayment(new CreditCardStrategy(), amount)) {
            DeliveryAgents deliveryAgents = assignDeliveryAgent().get();
            if (deliveryAgents != null) {
                long orderId = orderCounter.incrementAndGet();
                orderMap.put(orderId, order);
                order.setDeliveryAgent(deliveryAgents);
            }
        } else {
            throw new OrderNotCreatedException("Order is not created due to some intermittent issue");
        }
    }

    private Optional<DeliveryAgents> assignDeliveryAgent() {
        Collection<DeliveryAgents> deliveryAgents = getDeliveryMap().values();
        return deliveryAgents.stream().filter(deliveryAgents1 -> deliveryAgents1.getAvailabityStatus().getStatus().equals("Available")).findAny();

    }

    private List<OrderItem> getListOfOrderItemFromRestaurant(long restaurantId) throws NotEnoughQuantityException {
        Restaurants restaurants = restaurantMap.get(restaurantId);
        List<MenuItem> menuItem = restaurants.getRestaurantService().getMenuItem();
        Scanner scanner = new Scanner(System.in);
        List<OrderItem> orderItems = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to add item?");
            String ans = scanner.next();
            if (ans.equals("NO"))
                break;
            String item = scanner.next();
            int quantity = scanner.nextInt();
            for (MenuItem menuItem1 : menuItem) {
                if ( menuItem1.getFoodName().equals(item) && menuItem1.getQuantity() >= quantity) {
                    orderItems.add(new OrderItem(item, quantity, menuItem1.getPrice()));
                    System.out.println("Item added in the cart ");
                }
            }

        }
        return orderItems;
    }

    public void registerRestaurant(Restaurants restaurants) {
        long restaurantId = restaurantCounter.incrementAndGet();
        restaurantMap.put(restaurantId, restaurants);
    }

    public ConcurrentHashMap<Long, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(ConcurrentHashMap<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public ConcurrentHashMap<Long, Restaurants> getRestaurantMap() {
        return restaurantMap;
    }

    public void setRestaurantMap(ConcurrentHashMap<Long, Restaurants> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public ConcurrentHashMap<Long, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(ConcurrentHashMap<Long, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public ConcurrentHashMap<Long, DeliveryAgents> getDeliveryMap() {
        return DeliveryMap;
    }


    public void login(String username, String pwd) {
        Collection<Customer> customer4 = customerMap.values();
        Optional<Customer> customer1 = customer4.stream().filter(customer -> customer.getName().equals(username) && customer.getPassword().equals(pwd)).findAny();
        if (customer1.get() != null) {
            System.out.println("logged in successfully");
        } else {
            System.out.println("Bad credentials");
        }

    }

    public void ViewRestaurantsAndMenuItem() {
        Collection<Restaurants> restaurants = restaurantMap.values();
        for (Restaurants restaurants1 : restaurants) {
            List<MenuItem> menuItem = restaurants1.getRestaurantService().getMenuItem();
            for (MenuItem menuItem1 : menuItem) {
                System.out.print(menuItem1.getFoodId() + " ");
                System.out.print(menuItem1.getFoodName() + " ");;
                System.out.print(menuItem1.getPrice() + " ");
                System.out.print(menuItem1.getDescription() + " ");
                System.out.println();
            }
            System.out.println();
        }
    }


}
