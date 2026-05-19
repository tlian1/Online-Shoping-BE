package OnlineShoping;

public abstract class Product implements Comparable<Product>, Payable {
    protected int id;
    protected String title;
    protected double price;
    protected String description;
    protected boolean paid;
    private static int nextId = 1; // Счетчик для автогенерации ID

    public Product(String title, double price, String description) {
        this.id = nextId++;
        this.title = title;
        this.price = price;
        this.description = description;
        this.paid = false;
    }

    // Сортировка по умолчанию (Comparable) — по цене
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public double getFinalPrice() { return price; }

    @Override
    public void pay(double amount) {
        if (amount >= price) {
            paid = true;
            System.out.println(" Товар оплачен: " + title);
        } else {
            System.out.println(" Недостаточно средств для оплаты.");
        }
    }

    @Override
    public boolean isPaid() { return paid; }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    public abstract void showInfo(); // Абстрактный метод для вывода информации
}



