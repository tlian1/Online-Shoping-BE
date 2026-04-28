package OnlineShoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Catalog {
    private int id;
    private String title;
    private double price;
    private ArrayList<Category> categories;  // Список категорий
    private static int nextId = 1;

    public Catalog() {
        this.id = nextId++;
        this.categories = new ArrayList<>();
    }

    public Catalog(String title, double price) {
        this.id = nextId++;
        this.title = title;
        this.price = price;
        this.categories = new ArrayList<>();
    }


    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Метод addCategory - добавляет категорию в каталог
     */
    public void addCategory(Category category) {
        categories.add(category);
        System.out.println("✓ Категория '" + category.getTitle() + "' добавлена в каталог");
    }

    /**
     * СЧЁТЧИК 1: Общее количество всех категорий (включая подкатегории)
     */
    public int countAllCategories() {
        int count = categories.size();
        for (Category cat : categories) {            count += countSubCategoriesRecursive(cat);
        }
        return count;
    }

    /**
     * СЧЁТЧИК 2: Количество только подкатегорий (без корневых)
     */
    public int countSubCategories() {
        int count = 0;
        for (Category cat : categories) {
            count += countSubCategoriesRecursive(cat);
        }
        return count;
    }

    /**
     * Вспомогательный рекурсивный метод для подсчёта подкатегорий
     */
    private int countSubCategoriesRecursive(Category category) {
        int count = category.getSubCategories().size();
        for (Category sub : category.getSubCategories()) {
            count += countSubCategoriesRecursive(sub);
        }
        return count;
    }

    /**
     * Метод showCategory - показывает все категории в каталоге
     */
    public void showCategory() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           КАТАЛОГ: " + title);
        System.out.println("=".repeat(60));
        System.out.println("ID каталога: " + id);
        System.out.println("Всего категорий: " + countAllCategories());
        System.out.println("Всего подкатегорий: " + countSubCategories());
        System.out.println("Корневых категорий: " + categories.size());
        System.out.println("=".repeat(60));

        if (categories.isEmpty()) {
            System.out.println("Каталог пуст");
        } else {
            for (Category cat : categories) {
                cat.showCategory();
            }
        }
    }

    /**     * Сортировка категорий по названию
     */
    public void sortCategoriesByName() {
        Collections.sort(categories);  // Использует Comparable из Category
        System.out.println("Категории отсортированы по названию");
    }

    /**
     * Сортировка категорий с Comparator
     */
    public void sortCategories(Comparator<Category> comparator) {
        Collections.sort(categories, comparator);
        System.out.println("Категории отсортированы");
    }

    /**
     * Поиск категории по названию
     */
    public Category findCategoryByName(String name) {
        for (Category cat : categories) {
            if (cat.getTitle().equalsIgnoreCase(name)) {
                return cat;
            }
        }
        return null;
    }

    /**
     * Показать статистику каталога
     */
    public void showStatistics() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           СТАТИСТИКА КАТАЛОГА");


        System.out.println("=".repeat(60));
        System.out.println("Название: " + title);
        System.out.println("ID: " + id);
        System.out.println("Корневых категорий: " + categories.size());
        System.out.println("Всего категорий: " + countAllCategories());
        System.out.println("Всего подкатегорий: " + countSubCategories());

        int totalProducts = 0;
        for (Category cat : categories) {
            totalProducts += countProductsInCategory(cat);
        }
        System.out.println("Всего продуктов: " + totalProducts);
        System.out.println("=".repeat(60));
    }

    /**
     * Подсчёт продуктов в категории (рекурсивно)     */
    private int countProductsInCategory(Category category) {
        int count = category.getProducts().size();
        for (Category sub : category.getSubCategories()) {
            count += countProductsInCategory(sub);
        }
        return count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        long temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Catalog other = (Catalog) obj;
        if (id != other.id) return false;
        if (title == null) {
            if (other.title != null) return false;
        } else if (!title.equals(other.title)) return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Catalog{id=" + id + ", title='" + title + "', price=" + price +
                ", categories=" + countAllCategories() + ", subCategories=" + countSubCategories() + "}";
    }

    public void addCategory() {

    }
}
