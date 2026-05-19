package OnlineShoping;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount){
        System.out.println("Оплата наличными: $" + amount);
        return true;
    }

    @Override
    public String getMethodName() {
        return "Наличные";
    }
}
