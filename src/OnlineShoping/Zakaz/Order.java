package OnlineShoping.Zakaz;

import OnlineShoping.Transaktion.PaymentStrategy;
import OnlineShoping.Product.Product;
import OnlineShoping.Transaktion.TransactionRecord;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String clientName;
    private final List<Product> items;
    private final double totalAmount;
    private final PaymentStrategy paymentStrategy;
    private final List<TransactionRecord> history; // История неизменяемых записей

    public Order(String clientName, List<Product> items, double totalAmount, PaymentStrategy strategy) {
        this.clientName = clientName;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.paymentStrategy = strategy;
        this.history = new ArrayList<>();
    }

    public boolean pay() {
        System.out.println("\n Начало оплаты заказа для " + clientName);
        boolean success = paymentStrategy.processPayment(totalAmount);

        if (success) {
            // Создаём immutable запись в истории
            TransactionRecord record = new TransactionRecord(
                    "TX-" + System.currentTimeMillis(),
                    items.get(0).getTitle() + (items.size() > 1 ? " и др." : ""),
                    totalAmount * 1.1, // Пример исходной цены до скидки
                    totalAmount * 0.1, // Пример скидки
                    totalAmount
            );
            history.add(record);
            System.out.println(" Оплата прошла успешно. Транзакция записана.");
        } else {
            System.out.println(" Оплата отклонена.");
        }
        return success;
    }

    public void printHistory() {
        System.out.println("\n История транзакций заказа:");
        history.forEach(System.out::println);
    }

    public String getClientName() { return clientName; }
    public List<Product> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
}