package OnlineShoping;

public class Laptop extends Product {
    private int ram;
    private String processor;

    public Laptop(String title, double price, String description, int ram, String processor) {
        super(title, price, description, "Laptop");
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public void showInfo() {
        System.out.println("💻 " + title + " | $" + price + " | " + processor + " | " + ram + "GB RAM");
    }

    @Override
    public double getFinalPrice() {
        return this.price * 0.85;
    }

    @Override
    public void ShowInfo() {

    }

    public int getRam() { return ram; }
    public String getProcessor() { return processor; }

    @Override
    public String toString() {
        return "Laptop{ram=" + ram + "GB, processor='" + processor + "', " + super.toString() + "}";
    }
}
