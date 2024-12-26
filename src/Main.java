import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MenuItem item1 = new MenuItem("Cream Pasta", 4590, "Main Course");
        MenuItem item11 = new MenuItem("Lobster Risotto", 5690, "Main Course");
        MenuItem item2 = new MenuItem("Caviar Bisque", 4990, "Appetizer");
        MenuItem item21 = new MenuItem("Carpaccio", 3490, "Appetizer");
        MenuItem item3 = new MenuItem("Chocolate Soufflé", 3290, "Dessert");
        MenuItem item31 = new MenuItem("Opera Cake", 3890, "Dessert");

        // Creating orders for customers
        Order order1 = new Order(101, "Askhar");
        Order order2 = new Order(102, "Akbota");

        // Adding items to the first order
        order1.addItem(item1);
        order1.addItem(item21);
        order1.addItem(item3);

        // Adding items to the second order
        order2.addItem(item11);
        order2.addItem(item2);
        order2.addItem(item31);

        // a restaurant's name
        Restaurant restaurant = new Restaurant("La Dolce Vita");

        // Add all menu items to the restaurant's menu
        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item11);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item21);
        restaurant.addMenuItem(item3);
        restaurant.addMenuItem(item31);

        // Add orders to the restaurant
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);

        // output of restaurant details
        System.out.println(restaurant);

        // output of the full menu
        System.out.println("MENU:");
        restaurant.getMenu().forEach(System.out::println);

        // output of details of the first order and its total cost
        System.out.println();
        System.out.println(order1);
        System.out.println("Total for Order 1: " + order1.calculateTotal() + "tg");

        // output of details of the second order and its total cost
        System.out.println();
        System.out.println(order2);
        System.out.println("Total for Order 2: " + order2.calculateTotal() + "tg");
    }
}
