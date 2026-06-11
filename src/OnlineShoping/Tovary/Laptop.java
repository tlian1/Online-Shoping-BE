package OnlineShoping.Tovary;

import OnlineShoping.Product.Product;

public class Laptop extends Product {
    private int ram;
    private String processor;

    public Laptop(String title, double price, String description, int ram, String processor) {
        super(title, price, description);
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public void showInfo() {
        System.out.printf(" %s (%s) - $%.2f | RAM: %dGB%n", title, processor, price, ram);
    }
    public int getRam() { return ram; }
    public String getProcessor() { return processor; }
}