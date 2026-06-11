package OnlineShoping.Transaktion;

public interface Finansible {
    double checkBalance();


    boolean hasEnoughMoney(double amount);

    String getFinalStatus();


}
