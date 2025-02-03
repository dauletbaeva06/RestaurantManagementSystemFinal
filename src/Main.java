import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Restaurant restaurant = new Restaurant();

    public static void main(String[] args) {
        MenuItemRepository menuRepo = new MenuItemRepository();
        OrderRepository orderRepo = new OrderRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Menu\n2. Add Menu Item\n3. Place Order\n4. Exit\n5. Order Specific Item\n6. View Orders");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<MenuItem> menu = menuRepo.getAllMenuItems();
                    menu.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    menuRepo.addMenuItem(new MenuItem(0, name, price, category)); // ✅ Добавили id
                    System.out.println("Item added successfully!");
                    break;


                case 3:
                    System.out.print("Enter customer name: ");
                    String customer = scanner.nextLine();

                    List<MenuItem> allItems = menuRepo.getAllMenuItems();
                    orderRepo.addOrder(new Order(0, customer, "Pending", 0, allItems));
                    System.out.println("Order placed successfully!");
                    break;

                case 4:
                    System.exit(0);
                    break;

                case 5:
                    System.out.print("Enter item name to order: ");
                    String orderItem = scanner.nextLine();

                    MenuItem item = restaurant.searchMenuItem(orderItem);
                    if (item == null) {
                        System.out.println("Item not found!");
                        break;
                    }

                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    int orderId = (int) (System.currentTimeMillis() / 1000);

                    List<MenuItem> singleItemOrder = new ArrayList<>();
                    singleItemOrder.add(item);

                    Order order = new Order(
                            orderId,
                            customerName,
                            "Pending",
                            item.getPrice(),
                            singleItemOrder
                    );

                    orderRepo.addOrder(order);
                    restaurant.addOrder(order);

                    System.out.println("Order placed!");
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
