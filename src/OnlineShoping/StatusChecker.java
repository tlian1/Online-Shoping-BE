package OnlineShoping;

@FunctionalInterface
public interface StatusChecker {
    boolean check(OrderStatus status, double amount);
}
