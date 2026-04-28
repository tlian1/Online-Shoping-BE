package OnlineShoping;

public class MobileDevice extends Elecrtonic {
    private String brand;
    private int batteryCapacity;

    public MobileDevice(String title, String description) {
        super(title, description);
        this.brand = brand;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void showInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("КАТЕГОРИЯ: МОБИЛЬНОЕ УСТРОЙСТВО");
        System.out.println("=".repeat(50));
        System.out.println("ID: " + getId());
        System.out.println("Название: " + getTitle());
        System.out.println("Описание: " + getDescription());
        System.out.println("Бренд: " + brand);
        System.out.println("Батарея: " + batteryCapacity + " mAh");
    }

    public String getBrand() { return brand; }
    public int getBatteryCapacity() { return batteryCapacity; }
}

