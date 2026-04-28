package OnlineShoping;

public abstract class Product implements Payable, Comparable<Product> {
    protected int id;
    protected String title;
    protected double price;
    protected String description;
    protected boolean paid;
    protected String categoryType;
    protected static int nextId = 1;

    public Product(String title, double price, String description, String categoryType) {
        this.id = nextId++;
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryType = categoryType;
        this.paid = false;
    }


    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    public String getCategoryType() {
        return this.categoryType;
    }

    @Override
    public double getFinalPrice() {
        return this.price;
    }

    @Override
    public void pay(double amount) {
        if (amount >= this.price) {
            this.paid = true;
            System.out.println("Товар '" + title + "' оплачен. Сумма: $" + amount);
        } else {
            System.out.println("Недостаточная сумма. Нужно: $" + this.price);
        }
    }

    @Override
    public boolean isPaid() {
        return this.paid;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }

    public abstract void ShowInfo();

    public abstract void showInfo();

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
        Product other = (Product) obj;
        if (id != other.id) return false;
        if (title == null) {
            if (other.title != null) return false;
        } else if (!title.equals(other.title)) return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", title='" + title + "', price=" + price + ", category='" + categoryType + "'}";
    }
}