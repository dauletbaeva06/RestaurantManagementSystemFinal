import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name; // Name of the restaurant
    private List<MenuItem> menu; // List of menu items
    private List<Order> orders; // List of orders placed at the restaurant

    //the restaurant with a name
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>(); // Initialize an empty menu list
        this.orders = new ArrayList<>(); // Initialize an empty orders list
    }

    // using getter
    // the restaurant's name
    public String getName() {
        return name;
    }

    // the list of menu items
    public List<MenuItem> getMenu() {
        return menu;
    }

    // the list of orders
    public List<Order> getOrders() {
        return orders;
    }

    // using setter
    // the restaurant's name
    public void setName(String name) {
        this.name = name;
    }

    // Adding a menu item to the restaurant's menu
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Adding an order to the restaurant's list of orders
    public void addOrder(Order order) {
        orders.add(order);
    }

    public String toString() {
        return String.format("Restaurant: %s, Menu Items: %d, Orders: %d", name, menu.size(), orders.size());
    }
}
