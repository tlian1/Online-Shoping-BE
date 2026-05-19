package OnlineShoping;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executePayment(double amount) {
        if (strategy == null){
            throw new IllegalStateException("Стратегия оплаты не выбрана!");
        }
        System.out.println("Применение стратегии: " + strategy.getMethodName());
        return strategy.processPayment(amount);
    }
}
