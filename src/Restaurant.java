import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private List<Order> orders;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String toString() {
        return String.format("Restaurant: %s, Menu Items: %d, Orders: %d", name, menu.size(), orders.size());
    }
}
