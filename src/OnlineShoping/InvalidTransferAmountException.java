package OnlineShoping;
/*
* Неверная сумма перевода
 */

public class InvalidTransferAmountException extends RuntimeException{
    public InvalidTransferAmountException(String message){
        super("Неверная сумма перевода" + message);
    }

    public InvalidTransferAmountException(double amount){
        super("Неверная сумма переводов: $" + amount + "(должна быть больше 0)");
    }
}
