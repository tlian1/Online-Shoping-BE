package OnlineShoping;


public class GardenItem extends Product {
    private String season;
    private String material;

    public GardenItem(String title, double price, String description, String season, String material) {
        super(title, price, description, "GardenItem");
        this.season = season;
        this.material = material;
    }

    @Override
    public void ShowInfo() {

    }

    @Override
    public void showInfo() {
        System.out.println(title + " | $" + price + " | Сезон: " + season + " | Материал: " + material);
    }

    public String getSeason() {
        return season;
    }
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "GardenItem{season='" + season + "', material='" + material + "', " + super.toString() + "}";
    }
}