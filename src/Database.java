import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant management"; // Переименуйте базу данных, если возможно
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    public static Connection connect() {
        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Метод для безопасного закрытия соединения
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
