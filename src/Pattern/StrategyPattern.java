package Pattern;

public class StrategyPattern {
    public static void main(String[] args){
        strategyDemo();
    }

    private static void strategyDemo(){
        System.out.println("\n ======= 1. Strategy Pattern ========");

        PaymentStrategy cardPayment = new CardPayment();
        OrderService orderWithCard = new OrderService(cardPayment);
        orderWithCard.checkout(1000);

        PaymentStrategy CashPayment = new CashPayment();
        OrderService orderWithCash = new OrderService(CashPayment);
        orderWithCash.checkout(700);
    }

    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CardPayment implements PaymentStrategy {
        public void pay(int amount){
            System.out.println("Оплата картой: " + amount);
        }
    }

    static class CashPayment implements PaymentStrategy{
        public void pay(int amount){
            System.out.println("Оплата наличными: " + amount);
        }
    }

    static class BonusPayment implements PaymentStrategy{
        public void pay(int amount) {
            System.out.println("Оплата бонусами: " + amount);
        }
    }
    static class OrderService{
        private PaymentStrategy paymentStrategy;

        public OrderService(PaymentStrategy paymentStrategy){
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount){
            paymentStrategy.pay(amount);
        }
    }

}
