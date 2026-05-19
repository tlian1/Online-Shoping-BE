package OnlineShoping;


public interface PaymentStrategy {

    boolean processPayment(double amount);

    String getMethodName();
}
