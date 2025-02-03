import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<MenuItem> menuItems;
    private List<Order> orders;

    public Restaurant() {
        this.menuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public MenuItem searchMenuItem(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
