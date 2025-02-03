import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Restaurant restaurant = new Restaurant(); // Инициализация объекта ресторана

    public static void main(String[] args) {
        // Подключение к базе данных
        Connection connection = Database.connect(); // Подключение к базе данных через вспомогательный класс
        MenuItemRepository menuRepo = new MenuItemRepository(connection); // Репозиторий для работы с меню
        OrderRepository orderRepo = new OrderRepository(connection); // Репозиторий для работы с заказами
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Menu\n2. Add Menu Item\n3. Place Order\n4. Exit\n5. Order Specific Item\n6. View Orders");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Просмотр всех элементов меню
                    List<MenuItem> menu = menuRepo.getAllMenuItems();
                    if (menu.isEmpty()) {
                        System.out.println("Menu is empty!");
                    } else {
                        menu.forEach(System.out::println);
                    }
                    break;

                case 2:
                    // Добавление нового элемента в меню
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    menuRepo.addMenuItem(new MenuItem(0, name, price, category)); // Добавляем новый элемент в меню
                    System.out.println("Item added successfully!");
                    break;

                case 3:
                    // Оформление заказа с выбором всех элементов меню
                    System.out.print("Enter customer name: ");
                    String customer = scanner.nextLine();

                    List<MenuItem> allItems = menuRepo.getAllMenuItems();
                    if (allItems.isEmpty()) {
                        System.out.println("Menu is empty, can't place order.");
                        break;
                    }

                    System.out.println("Available menu items:");
                    allItems.forEach(System.out::println);

                    System.out.print("Enter item name to order: ");
                    String orderItemName = scanner.nextLine().trim();  // Убираем пробелы
                    MenuItem orderedItem = menuRepo.searchMenuItem(orderItemName);
                    if (orderedItem == null) {
                        System.out.println("Item not found!");
                        break;
                    }

                    int orderId = (int) (System.currentTimeMillis() / 1000);
                    List<MenuItem> singleItemOrder = new ArrayList<>();
                    singleItemOrder.add(orderedItem);

                    double totalPrice = orderedItem.getPrice();

                    Order newOrder = new Order(orderId, customer, "Pending", totalPrice, singleItemOrder);
                    orderRepo.addOrder(newOrder);
                    restaurant.addOrder(newOrder);

                    System.out.println("Order placed successfully!");
                    break;

                case 4:
                    System.exit(0);
                    break;

                case 5:
                    System.out.print("Enter item name to order: ");
                    String orderSpecificItemName = scanner.nextLine().trim();

                    MenuItem specificItem = menuRepo.searchMenuItem(orderSpecificItemName);
                    if (specificItem == null) {
                        System.out.println("Item not found!");
                        break;
                    }

                    System.out.print("Enter customer name: ");
                    String specificCustomerName = scanner.nextLine().trim();  // Убираем пробелы

                    int specificOrderId = (int) (System.currentTimeMillis() / 1000);

                    List<MenuItem> specificItemOrder = new ArrayList<>();
                    specificItemOrder.add(specificItem);

                    double specificTotalPrice = specificItem.getPrice();

                    Order specificOrder = new Order(
                            specificOrderId,
                            specificCustomerName,
                            "Pending",
                            specificTotalPrice,
                            specificItemOrder
                    );

                    orderRepo.addOrder(specificOrder);
                    restaurant.addOrder(specificOrder);

                    System.out.println("Order placed for specific item!");
                    break;

                case 6:
                    restaurant.printOrders();
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }
        }
    }
}
