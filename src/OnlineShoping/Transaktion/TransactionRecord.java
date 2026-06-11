package OnlineShoping.Transaktion;

import java.time.LocalDateTime;

public final class TransactionRecord {
    private final String transaction;
    private final String productName;
    private final double originalPrice;
    private final double discount;
    private final double finalAmount;
    private final LocalDateTime timestamp;

    public TransactionRecord(String transaction, String productName,
                             double originalPrice, double discount, double finalAmount) {
        this.transaction = transaction;
        this.productName = productName;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.timestamp = LocalDateTime.now();
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Было: $%.2f | Скидка: $%.2f | %s",
                transaction, productName, originalPrice, discount, finalAmount, timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof  TransactionRecord)) return false;
        TransactionRecord that = (TransactionRecord) obj;
        return transaction.equals(that.transaction);
    }

    @Override
    public int hashCode() {
        return transaction.hashCode();
    }
}
