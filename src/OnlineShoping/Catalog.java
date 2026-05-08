package OnlineShoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Catalog {
    private String title;
    private ArrayList<Category> categories;

    public Catalog(String title) {
        this.title = title;
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category cat) { categories.add(cat); }

    public int countAllCategories() {
        int count = categories.size();
        for (Category c : categories) count += countRecursive(c);
        return count;
    }

    private int countRecursive(Category c) {
        int count = c.getSubCategories().size();
        for (Category sub : c.getSubCategories()) count += countRecursive(sub);
        return count;
    }

    public void showStatistics() {
        System.out.println("   Статистика каталога '" + title + "':");
        System.out.println("   Корневых категорий: " + categories.size());
        System.out.println("   Всего категорий (с подкатегориями): " + countAllCategories());
    }
}