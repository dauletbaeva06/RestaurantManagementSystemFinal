import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Connection failure: " + e.getMessage());
        }
        return connection;
    }
}
