import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {
    private Connection connection;

    // Конструктор для инициализации соединения
    public MenuItemRepository(Connection connection) {
        this.connection = connection;
    }

    // Метод для получения всех элементов меню
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");

                menuItems.add(new MenuItem(id, name, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    // Метод для добавления нового элемента в меню
    public void addMenuItem(MenuItem menuItem) {
        String sql = "INSERT INTO menu_items (name, price, category) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, menuItem.getName());
            stmt.setDouble(2, menuItem.getPrice());
            stmt.setString(3, menuItem.getCategory());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для поиска элемента по имени
    public MenuItem searchMenuItem(String itemName) {
        String sql = "SELECT * FROM menu_items WHERE name = ?";
        MenuItem menuItem = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, itemName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");

                menuItem = new MenuItem(id, name, price, category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuItem;
    }
}
