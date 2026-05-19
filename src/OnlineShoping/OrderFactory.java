package OnlineShoping;

import java.util.List;

public class OrderFactory {
    public static Order createOrder(String clientName, List<Product> items, PaymentStrategy strategy) {
        double total = items.stream().mapToDouble(Product::getFinalPrice).sum();
        return new Order(clientName, items, total, strategy);
    }
}
