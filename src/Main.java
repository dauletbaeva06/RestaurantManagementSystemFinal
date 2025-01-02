import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("La Dolce Vita");
        Scanner scanner = new Scanner(System.in);

        restaurant.addMenuItem(new MenuItem("Cream Pasta", 4590, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Lobster Risotto", 5690, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Caviar Bisque", 4990, "Appetizer"));
        restaurant.addMenuItem(new MenuItem("Carpaccio", 3490, "Appetizer"));
        restaurant.addMenuItem(new MenuItem("Chocolate Soufflé", 3290, "Dessert"));
        restaurant.addMenuItem(new MenuItem("Opera Cake", 3890, "Dessert"));

        while (true) {
            System.out.println("\nWelcome to " + restaurant.getName() + " Management System");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. Place an Order");
            System.out.println("5. View Orders");
            System.out.println("6. Edit Order");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("MENU:");
                    restaurant.getMenu().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    restaurant.addMenuItem(new MenuItem(name, price, category));
                    System.out.println("Menu item added!");
                    break;

                case 3:
                    System.out.print("Enter item name to remove: ");
                    String itemNameToRemove = scanner.nextLine();
                    restaurant.removeMenuItem(itemNameToRemove);
                    System.out.println("Menu item removed!");
                    break;

                case 4:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Order order = new Order(restaurant.getOrders().size() + 1, customerName);
                    while (true) {
                        System.out.print("Enter item name to add to order (or 'done' to finish): ");
                        String itemName = scanner.nextLine();
                        if (itemName.equalsIgnoreCase("done")) break;
                        MenuItem menuItem = restaurant.getMenu().stream()
                                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                                .findFirst()
                                .orElse(null);
                        if (menuItem != null) {
                            order.addItem(menuItem);
                            System.out.println("Item added to order!");
                        } else {
                            System.out.println("Item not found in the menu.");
                        }
                    }
                    restaurant.addOrder(order);
                    System.out.println("Order placed!");
                    break;

                case 5:
                    System.out.println("ORDERS:");
                    restaurant.getOrders().forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Enter Order ID to edit: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Order orderToEdit = restaurant.getOrders().stream()
                            .filter(o -> o.getOrderId() == orderId)
                            .findFirst()
                            .orElse(null);
                    if (orderToEdit != null) {
                        System.out.print("Enter item name to remove from order: ");
                        String itemToRemove = scanner.nextLine();
                        orderToEdit.removeItem(itemToRemove);
                        System.out.println("Item removed from order!");
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}