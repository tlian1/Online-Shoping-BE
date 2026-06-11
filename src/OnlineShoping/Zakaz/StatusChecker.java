package OnlineShoping.Zakaz;

@FunctionalInterface
public interface StatusChecker {
    boolean check(OrderStatus status, double amount);
}
