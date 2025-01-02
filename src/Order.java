import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Order {
    private int orderId;
    private String customerName;
    private List<MenuItem> items;
    private String status;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.status = "Pending"; // Default status
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Add an item to the order
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Remove an item from the order
    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    // Calculate total price
    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public String toString() {
        String itemsStr = items.stream().map(MenuItem::getName).collect(Collectors.joining(", "));
        return String.format("Order ID: %d, Customer: %s, Items: [%s], Status: %s", orderId, customerName, itemsStr, status);
    }
}