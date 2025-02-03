import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private String status;
    private double totalPrice;
    private List<MenuItem> items;

    public Order(int id, String customerName, String status, double totalPrice, List<MenuItem> items) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
    public double getTotalPrice() { return totalPrice; }
    public List<MenuItem> getItems() { return items; }

    @Override
    public String toString() {
        return String.format("Order{id=%d, customer='%s', status='%s', totalPrice=%.2f, items=%s}",
                id, customerName, status, totalPrice, items);
    }
}
