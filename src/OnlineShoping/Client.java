package OnlineShoping;

public class Client implements Finansible {
    private String name;
    private double balance;
    private double creditLimit;
    private static final double DEFAULT_CREDIT_LIMIT = 5000.0;

    public Client(String name, double balance) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(" Имя клиента не может быть пустым!");
        }
        if (balance < 0) {
            throw new IllegalArgumentException(" Баланс не может быть отрицательным!");
        }

        this.name = name;
        this.balance = balance;
        this.creditLimit = DEFAULT_CREDIT_LIMIT;
    }

    public Client(String name, double balance, double creditLimit) {
        this(name, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public double checkBalance() {
        return balance;
    }
    @Override
    public boolean hasEnoughMoney(double amount) {
        if (amount < 0) {
            return false;
        }
        return balance >= amount;
    }

    /**
     * Проверка с учётом кредитного лимита
     */
    public boolean canAfford(double amount) throws CreditLimitExceededException {
        if (amount < 0) {
            throw new IllegalArgumentException(" Сумма не может быть отрицательной!");
        }

        double totalAvailable = balance + creditLimit;
        if (amount > totalAvailable) {
            throw new CreditLimitExceededException(totalAvailable, amount);
        }
        return true;
    }

    @Override
    public String getFinalStatus() {
        if (balance > 1000) return "VIP Клиент";
        if (balance > 500) return "Стандартный Клиент";
        return "Новый Клиент";
    }

    /**
     * Покупка товара с обработкой исключений
     */
    public void buy(Product product) throws InsufficientFundsException, PaymentFailedException {
        if (product == null) {
            throw new IllegalArgumentException(" Нельзя купить null товар!");
        }

        double price = product.getFinalPrice();

        if (!hasEnoughMoney(price)) {
            throw new InsufficientFundsException(price, balance);
        }

        try {
            balance -= price;
            product.pay(price);
            System.out.println(" С баланса клиента " + name + " списано $" + price);
        } catch (Exception e) {
            throw new PaymentFailedException("Списание средств", e.getMessage());
        }
    }

    /**
     * Пополнение баланса
     */
    public void addBalance(double amount) throws InvalidTransferAmountException {
        if (amount <= 0) {
            throw new InvalidTransferAmountException(amount);
        }

        balance += amount;
        System.out.println(" Баланс клиента " + name + " пополнен на $" + amount);
    }

    /**
     * Перевод средств другому клиенту
     */
    public void transferTo(Client recipient, double amount)
            throws InsufficientFundsException, InvalidTransferAmountException {
        if (recipient == null) {
            throw new IllegalArgumentException(" Нельзя перевести средства null клиенту!");
        }

        if (amount <= 0) {
            throw new InvalidTransferAmountException(amount);
        }

        if (!hasEnoughMoney(amount)) {
            throw new InsufficientFundsException(amount, balance);
        }

        this.balance -= amount;
        recipient.balance += amount;

        System.out.println(" Перевод $" + amount + " от " + this.name + " к " + recipient.name + " выполнен");
    }

    public String getName() { return name; }
    public double getCreditLimit() { return creditLimit; }
}



