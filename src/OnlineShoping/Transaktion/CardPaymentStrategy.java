package OnlineShoping.Transaktion;

public class CardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Оплата картой (****" + cardNumber.substring(12) + "): $" + amount);
        return true;
    }

    @Override
    public String getMethodName() {
        return "Банковская карта";
    }
}
