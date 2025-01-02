class MenuItem extends BaseEntity {
    private double price;
    private String category;

    public MenuItem(String name, double price, String category) {
        super(name);
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Overridden methods
    @Override
    public String toString() {
        return String.format("MenuItem: %s, Price: %.2f, Category: %s", getName(), price, category);
    }
}