public class MenuItem {
    private String name;
    private double price;
    private String category;

    // the menu item attributes
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // using getter
    // the item name
    public String getName() {
        return name;
    }

    // the item price
    public double getPrice() {
        return price;
    }

    // the item category
    public String getCategory() {
        return category;
    }

    // using setter
    // the item name
    public void setName(String name) {
        this.name = name;
    }

    // the item price
    public void setPrice(double price) {
        this.price = price;
    }

    // the item category
    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return String.format("MenuItem: %s, Price: %.2f, Category: %s", name, price, category);
    }
}

