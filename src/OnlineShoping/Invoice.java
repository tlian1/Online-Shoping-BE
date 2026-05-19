package OnlineShoping;

import java.util.List;

public class Invoice {
    private final String invoceNumber;
    private final String clientName;
    private final List<Product> items;
    private final double totalAmount;

    public Invoice(String invoceNumber, String clientName,
                   List<Product> items, double totalAmount) {
        this.invoceNumber = invoceNumber;
        this.clientName = clientName;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public void printInvoice(){
        System.out.println("\n СЧЕТ" + invoceNumber);
        System.out.println("Клиент: " + clientName);
        System.out.println("Товары");
        items.forEach(p -> System.out.println(" - " + p.getTitle() + "($" + p.getFinalPrice() + ")"));
        System.out.println("ИТОГО: $" + totalAmount);
        System.out.println("=".repeat(40));
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public List<Product> getItems(){
        return items;
    }
}
