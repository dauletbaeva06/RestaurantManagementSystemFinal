import java.util.*;
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

    public List<MenuItem> filterMenuByCategory(String category) {
        return menu.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public MenuItem searchMenuItem(String name) {
        return menu.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<MenuItem> sortMenuByPrice(boolean ascending) {
        return menu.stream()
                .sorted((a, b) -> ascending ? Double.compare(a.getPrice(), b.getPrice()) : Double.compare(b.getPrice(), a.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s, Menu Items: %d, Orders: %d", getName(), menu.size(), orders.size());
    }
}