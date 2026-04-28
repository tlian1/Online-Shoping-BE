package OnlineShoping;

public class Product extends Category implements payble{
    private int id;
    private String title;
    private double price;
    private  String description;
    private static int nextId = 1;

    public Product() {}

    @Override
    public void ShowInfo() {

    }

    @Override
    public String getType() {
        return "";
    }

    public Product(String title, double price, String description){
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @Override
    public void SnowInfo() {

    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public double getFinalPrice() {
        return 0;
    }


    @Override
    public void pay(double amount) {

    }


    @Override
    public boolean isPaid() {
        return false;
    }
}
