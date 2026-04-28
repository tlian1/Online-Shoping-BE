package OnlineShoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Category implements Payable, Comparable<Category> {
    protected int id;
    protected String title;
    protected String description;
    protected ArrayList<Category> subCategories;
    protected ArrayList<Product> products;
    protected static int nextId = 1;

    public Category(String title, String description) {
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.subCategories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    protected Category() {
    }

    @Override
    public int compareTo(Category other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public ArrayList<Category> getSubCategories() { return subCategories; }
    public ArrayList<Product> getProducts() { return products; }

    public void addCategory(Category category) {
        subCategories.add(category);
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Продукт '" + product.getTitle() + "' добавлен в категорию '" + title + "'");
    }

    public void sortProductsDefault() {
        Collections.sort(products);
        System.out.println("Продукты отсортированы по цене");
    }

    public void sortProducts(Comparator<Product> comparator) {
        Collections.sort(products, comparator);
        System.out.println("Продукты отсортированы");
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("  Продуктов нет");
        } else {
            System.out.println("\n  Продукты (" + products.size() + "):");
            for (int i = 0; i < products.size(); i++) {
                System.out.print("    " + (i + 1) + ". ");
                products.get(i).showInfo();
            }
        }
    }

    public void showCategory() {
        showInfo();
        showProducts();

        if (!subCategories.isEmpty()) {
            System.out.println("\n  Подкатегории (" + subCategories.size() + "):");
            for (Category sub : subCategories) {
                sub.showCategory();
            }
        }
        System.out.println("  " + "=".repeat(50));
    }

    public abstract void ShowInfo();

    public abstract String getType();

    public abstract void SnowInfo();

    public abstract void showInfo();
}