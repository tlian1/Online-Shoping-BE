package OnlineShoping;

public class Elecrtonic extends Category {

    public Elecrtonic(String title, String description) {
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
        System.out.println("КАТЕГОРИЯ: ЭЛЕКТРОНИКА");
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
