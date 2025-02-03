import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(Order order) {
        String itemsString = "";
        List<MenuItem> items = order.getItems();
        if (items != null && !items.isEmpty()) {
            itemsString = items.stream()
                    .map(MenuItem::getName)
                    .collect(Collectors.joining(", "));
        }

        String sql = "INSERT INTO orders (customer_name, status, total_price, items) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getStatus());
            stmt.setDouble(3, order.getTotalPrice());
            stmt.setString(4, itemsString);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
