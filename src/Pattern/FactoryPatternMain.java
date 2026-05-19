package Pattern;

public class FactoryPatternMain {
    public static void main(String[] args) {
        factoryDemo();
    }

    private static void factoryDemo() {
        System.out.println("\n ======== 2. Factory Pattern ========");

        StrategyPattern.PaymentStrategy payment1 = PaymentFactory.createPayment("CARD");
        payment1.pay(1500);

        StrategyPattern.PaymentStrategy payment2 = PaymentFactory.createPayment("CASH");
        payment2.pay(500);

        StrategyPattern.PaymentStrategy payment3 = PaymentFactory.createPayment("BONUS");
        payment3.pay(300);
    }

    static class PaymentFactory {

        public static StrategyPattern.PaymentStrategy createPayment(String type){
            if (type.equals("CARD")){
                return new StrategyPattern.CardPayment();
            }

            if (type.equals("CASH")){
                return new StrategyPattern.CashPayment();
            }

            if (type.equals("BONUS")){
                return new StrategyPattern.BonusPayment();
            }

            throw new IllegalArgumentException("Неизвестный тип оплаты: " + type);
        }
    }
}
