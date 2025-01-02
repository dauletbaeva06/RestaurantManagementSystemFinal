import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("La Dolce Vita");
        Scanner scanner = new Scanner(System.in);

        // Sample data
        restaurant.addMenuItem(new MenuItem("Cream Pasta", 4590, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Caviar Bisque", 4990, "Appetizer"));
        restaurant.addMenuItem(new MenuItem("Chocolate Soufflé", 3290, "Dessert"));
        restaurant.addMenuItem(new MenuItem("Lobster Risotto", 5690, "Main Course"));
        restaurant.addMenuItem(new MenuItem("Carpaccio", 3490, "Appetizer"));
        restaurant.addMenuItem(new MenuItem("Opera Cake", 3890, "Dessert"));

        // User interaction loop
        while (true) {
            System.out.println("\nWelcome to " + restaurant.getName() + " Management System");
            System.out.println("1. View Menu");
            System.out.println("2. Filter Menu by Category");
            System.out.println("3. Search Menu Item");
            System.out.println("4. Sort Menu by Price");
            System.out.println("5. Place an Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("MENU:");
                    restaurant.getMenu().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter category to filter: ");
                    String category = scanner.nextLine();
                    List<MenuItem> filteredMenu = restaurant.filterMenuByCategory(category);
                    System.out.println("Filtered Menu:");
                    filteredMenu.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter item name to search: ");
                    String itemName = scanner.nextLine();
                    MenuItem menuItem = restaurant.searchMenuItem(itemName);
                    System.out.println(menuItem != null ? menuItem : "Item not found!");
                    break;

                case 4:
                    System.out.print("Sort by price (true = ascending, false = descending): ");
                    boolean ascending = scanner.nextBoolean();
                    List<MenuItem> sortedMenu = restaurant.sortMenuByPrice(ascending);
                    System.out.println("Sorted Menu:");
                    sortedMenu.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Order order = new Order(restaurant.getOrders().size() + 1, customerName);
                    while (true) {
                        System.out.print("Enter item name to add to order (or 'done' to finish): ");
                        String name = scanner.nextLine();
                        if (name.equalsIgnoreCase("done")) break;
                        MenuItem item = restaurant.searchMenuItem(name);
                        if (item != null) {
                            order.addItem(item);
                            System.out.println("Item added to order!");
                        } else {
                            System.out.println("Item not found in the menu.");
                        }
                    }
                    restaurant.addOrder(order);
                    System.out.println("Order placed!");
                    break;

                case 6:
                    System.out.println("ORDERS:");
                    restaurant.getOrders().forEach(System.out::println);
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