package OnlineShoping.Tovary;

import OnlineShoping.Category.Category;

public class Electronic extends Category {
    public Electronic(String title, String description) {
        super(title, description);
    }
    @Override
    public void showInfo() {
        System.out.println(" Категория: " + title);
    }
}
