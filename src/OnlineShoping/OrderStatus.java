package OnlineShoping;

public enum OrderStatus {
    CREATED("Создан"),
    PAID("Оплачен"),
    SHIPPED("В пути"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменен");

    private final String label;

    OrderStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
