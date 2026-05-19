package OnlineShoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Catalog {
    private String title;
    private ArrayList<Category> categories;
    private static final int MAX_CATEGORIES = 100; // Лимит категорий

    public Catalog(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(" Название каталога не может быть пустым!");
        }
        this.title = title;
        this.categories = new ArrayList<>();
    }

    /**
     * Добавить категорию с проверкой лимита
     */
    public void addCategory(Category cat) throws CategoryLimitExceededException {
        if (cat == null) {
            throw new IllegalArgumentException(" Нельзя добавить null категорию!");
        }

        if (categories.size() >= MAX_CATEGORIES) {
            throw new CategoryLimitExceededException(title, MAX_CATEGORIES, categories.size() + 1);
        }

        categories.add(cat);
        System.out.println(" Категория '" + cat.getTitle() + "' добавлена в каталог");
    }

    /**
     * Найти категорию по названию
     */
    public Category findCategoryByName(String name) throws ProductNotFoundException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(" Название категории не может быть пустым!");
        }

        for (Category cat : categories) {
            if (cat.getTitle().equalsIgnoreCase(name)) {
                return cat;
            }
        }

        throw new ProductNotFoundException("Категория '" + name + "' не найдена");
    }

    // ... остальные методы (countAllCategories, showStatistics и т.д.)

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
        System.out.println("\n Статистика каталога '" + title + "':");
        System.out.println("   Корневых категорий: " + categories.size());
        System.out.println("   Всего категорий: " + countAllCategories());
        System.out.println("   Лимит категорий: " + MAX_CATEGORIES);
    }

    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories); // Возвращаем копию для безопасности
    }

    public String getTitle() {
        return title;
    }
}