package OnlineShoping;

public class GardenCategory extends Category {
    public GardenCategory(String title, String description) {
        super(title, description);
    }

    @Override
    public void ShowInfo() {

    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public void SnowInfo() {

    }

    @Override
    public void showInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🌱 КАТЕГОРИЯ: САДОВЫЕ ТОВАРЫ");
        System.out.println("=".repeat(50));
        System.out.println("ID: " + getId());
        System.out.println("Название: " + getTitle());
        System.out.println("Описание: " + getDescription());
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
