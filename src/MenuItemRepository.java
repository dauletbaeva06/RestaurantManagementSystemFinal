import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menu = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.isBeforeFirst()) {
                System.out.println("No menu items found.");
                return menu;
            }

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Columns found in ResultSet:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnName(i));
            }

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");

                menu.add(new MenuItem(id, name, price, category));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching menu items: " + e.getMessage());
        }
        return menu;
    }

    public void addMenuItem(MenuItem menuItem) {
    }
}
