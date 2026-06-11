package OnlineShoping.Transaktion;


public interface PaymentStrategy {

    boolean processPayment(double amount);

    String getMethodName();
}
