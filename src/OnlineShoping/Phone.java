package OnlineShoping;

public class Phone extends Product {
    private String brand;
    private int batteryCapacity;

    public Phone(String title, double price, String description, String brand, int batteryCapacity) {
        super(title, price, description, "Phone");
        this.brand = brand;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void showInfo() {
        System.out.println(title + " | $" + price + " | " + brand + " | " + batteryCapacity + "mAh");
    }

    @Override
    public double getFinalPrice() {
        return this.price * 0.90;
    }

    @Override
    public void ShowInfo() {

    }

    public String getBrand() { return brand; }
    public int getBatteryCapacity() { return batteryCapacity; }

    @Override
    public String toString() {
        return "Phone{brand='" + brand + "', battery=" + batteryCapacity + "mAh, " + super.toString() + "}";
    }
}
