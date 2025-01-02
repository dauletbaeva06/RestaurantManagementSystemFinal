import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Restaurant extends BaseEntity {
    private List<MenuItem> menu;
    private List<Order> orders;

    public Restaurant(String name) {
        super(name);
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(String itemName) {
        menu.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
