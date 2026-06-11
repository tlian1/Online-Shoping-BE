package OnlineShoping.Exception;
/*
* Превышен кредитный лимит
 */

public class CreditLimitExceededException extends RuntimeException{
    private final double creditLimit;
    private final double requestedAmount;

    public CreditLimitExceededException(double creditLimit, double requestedAmount){
        super(String.format("Превышен кредитный лимит! Лимит: $%.2f",
                creditLimit, requestedAmount));
        this.creditLimit = creditLimit;
        this.requestedAmount = requestedAmount;
    }
}
