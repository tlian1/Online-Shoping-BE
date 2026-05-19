package OnlineShoping;
/*
* Недостаточно средств
 */

public class InsufficientFundsException extends RuntimeException{
    private final double required;
    private final double available;

    public InsufficientFundsException(double required, double available){
        super(String.format("Недостаточно средств! Требуется: $%.2f, Доступно: $%.2f",
                required, available));
        this.required = required;
        this.available = available;
    }

    public double getShortfall(){
        return required - available;
    }
}
