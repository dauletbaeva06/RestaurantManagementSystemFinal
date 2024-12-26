import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
        private int orderId;
        private String customerName;
        private List<MenuItem> items;
        private String status;

    public Order(int orderId, String customerName) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = new ArrayList<>();
            this.status = "Pending"; // Default status of order is Pending
        }

        // using getter
        // the order ID
        public int getOrderId() {
            return orderId;
        }

        // the customer's name
        public String getCustomerName() {
            return customerName;
        }

        // the list of items in the order
        public List<MenuItem> getItems() {
            return items;
        }

        // the order status
        public String getStatus() {
            return status;
        }

        // using setter
        //the order ID
        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        // the customer's name
        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        // the order status
        public void setStatus(String status) {
            this.status = status;
        }

        // Add a menu item to the order
        public void addItem(MenuItem item) {
            items.add(item);
        }

        // Calculating the total price
        public double calculateTotal() {
            return items.stream().mapToDouble(MenuItem::getPrice).sum();
        }

        public String toString() {
            String itemsStr = items.stream().map(MenuItem::getName).collect(Collectors.joining(", "));
            return String.format("Order ID: %d, Customer: %s, Items: [%s], Status: %s", orderId, customerName, itemsStr, status);
        }
    }

