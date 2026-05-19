package OnlineShoping;

import java.util.ArrayList;

public abstract class Category implements Comparable<Category> {
    protected int id;
    protected String title;
    protected String description;
    protected ArrayList<Category> subCategories;
    protected ArrayList<Product> products;
    private static int nextId = 1;

    public Category(String title, String description) {
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.subCategories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    // Сортировка категорий по названию
    @Override
    public int compareTo(Category other) {
        return this.title.compareTo(other.title);
    }

    public void addCategory(Category cat) { subCategories.add(cat); }
    public void addProduct(Product prod) { products.add(prod); }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public ArrayList<Category> getSubCategories() { return subCategories; }
    public ArrayList<Product> getProducts() { return products; }

    public abstract void showInfo();

    // Рекурсивный вывод категории и всех её подкатегорий
    public void showCategory() {
        showInfo();
        System.out.println("   Товары в категории: " + products.size());
        for (Product p : products) System.out.println("    - " + p.getTitle());

        for (Category c : subCategories) c.showCategory();
    }
}