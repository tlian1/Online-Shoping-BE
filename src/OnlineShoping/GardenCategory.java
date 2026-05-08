package OnlineShoping;

public class GardenCategory extends Category {
    public GardenCategory(String title, String description) {
        super(title, description);
    }
    @Override
    public void showInfo() {
        System.out.println(" Категория: " + title);
    }
}