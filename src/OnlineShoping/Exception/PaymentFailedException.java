package OnlineShoping.Exception;
/*
* Ошибка оплаты
 */

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String message){
        super("Ошибка оплаты: " + message);
    }

    public PaymentFailedException(String methorName, String reason){
        super("Оплата методом " + methorName + "не удалась: " + reason);
    }
}
