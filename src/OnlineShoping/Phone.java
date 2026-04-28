package OnlineShoping;

public class Phone extends Product {
    private String brand;
    private int battery;
    private String title;
    private double price;
    private String description;


    public Phone(String title, double price, String description){
        super(title, price, description);
        this.brand = "Неизвестно";
        this.battery = 3000;
    }


    public void SnowInfo() {
        System.out.println("Телефон" + title + "руб" + price + brand + battery + "mAh");
    }


    public Phone(String title, double price, String description, String brand, int battery){
        super(title, price, description);
        this.brand = brand;
        this.battery = battery;
    }

    @Override
    public void ShowInfo(){
        System.out.println("Телефон" + title + "руб" + price + brand + battery + "mAh");
    }
    public String getBrand(){
        return brand;
    }
}
