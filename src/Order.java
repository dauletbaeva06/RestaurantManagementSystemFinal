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

    public String getCustomerName() {
        return customerName;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}

