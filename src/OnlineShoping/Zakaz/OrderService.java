package OnlineShoping.Zakaz;

import OnlineShoping.pabota_s_tovarom.Invoice;
import OnlineShoping.Transaktion.PaymentContext;
import OnlineShoping.Transaktion.PaymentStrategy;
import OnlineShoping.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final PaymentContext paymentContext;
    private final List<Order> orders;

    // Внедрение конструктора (DI)
    public OrderService(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
        this.orders = new ArrayList<>();
    }

    public Order createAndPayOrder(String clientName, List<Product> products, PaymentStrategy strategy) {
        paymentContext.setStrategy(strategy);

        Order order = OrderFactory.createOrder(clientName, products, strategy);
        Invoice invoice = InvoiceFactory.createInvoice(order);
        invoice.printInvoice();

        if (order.pay()) {
            orders.add(order);
            return order;
        }
        return null;
    }

    public List<Order> getAllOrders() { return orders; }
}
