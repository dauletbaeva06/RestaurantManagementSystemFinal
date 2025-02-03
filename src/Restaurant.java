import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<MenuItem> menuItems;
    private List<Order> orders; // Список заказов

    public Restaurant() {
        this.menuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added to restaurant orders.");
    }

    // Метод поиска блюда в меню по названию
    public MenuItem searchMenuItem(String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Если не найдено
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void printOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        System.out.println("Current Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
