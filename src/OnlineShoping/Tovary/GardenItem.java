package OnlineShoping.Tovary;


import OnlineShoping.Product.Product;

public class GardenItem extends Product {
    private String season;

    public GardenItem(String title, double price, String description, String season) {
        super(title, price, description);
        this.season = season;
    }

    @Override
    public void showInfo() {
        System.out.printf(" %s - $%.2f | Сезон: %s%n", title, price, season);
    }
    public String getSeason() { return season; }
}