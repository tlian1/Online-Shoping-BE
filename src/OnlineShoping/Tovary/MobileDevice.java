package OnlineShoping.Tovary;

public class MobileDevice extends Electronic {
    public MobileDevice(String title, String description) {
        super(title, description);
    }
    @Override
    public void showInfo() {
        System.out.println(" Подкатегория: " + title);
    }
}