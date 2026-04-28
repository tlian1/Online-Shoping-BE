package OnlineShoping;

public interface payble {

    double getFinalPrice();

    void pay(double amount);

    boolean isPaid();
}
