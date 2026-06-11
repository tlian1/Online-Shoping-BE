package OnlineShoping.Tovary;

import OnlineShoping.Product.Product;

public class Phone extends Product {
    private String brand;
    private int battery;

    public Phone(String title, double price, String description, String brand, int battery) {
        super(title, price, description);
        this.brand = brand;
        this.battery = battery;
    }

    @Override
    public void showInfo() {
        System.out.printf("%s (%s) - $%.2f | Batt: %dmAh%n", title, brand, price, battery);
    }
    public String getBrand() { return brand; }
    public int getBattery() { return battery; }
}
