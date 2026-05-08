package OnlineShoping;

public class Order {
    private String productName;
    private double amount;
    private OrderStatus status;

    public Order(String productName, double amount, OrderStatus status) {
        this.productName = productName;
        this.amount = amount;
        this.status = status;
    }

    public String getProductName() { return productName; }
    public double getAmount() { return amount; }
    public OrderStatus getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Заказ: %s | $%.2f | %s", productName, amount, status.getLabel());
    }
}
