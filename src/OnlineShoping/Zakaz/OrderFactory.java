package OnlineShoping.Zakaz;

import OnlineShoping.Transaktion.PaymentStrategy;
import OnlineShoping.Product.Product;

import java.util.List;

public class OrderFactory {
    public static Order createOrder(String clientName, List<Product> items, PaymentStrategy strategy) {
        double total = items.stream().mapToDouble(Product::getFinalPrice).sum();
        return new Order(clientName, items, total, strategy);
    }
}
