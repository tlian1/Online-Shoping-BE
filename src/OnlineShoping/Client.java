package OnlineShoping;

public class Client implements Finansible {

    private int id;
    private String name;
    private String email;
    private double balance;

    // Статический счетчик для автогенерации ID
    private static int nextId = 1;

    /**
     * Конструктор для создания клиента
     * @param name Имя клиента
     * @param email Почта
     * @param balance Начальный баланс
     */
    public Client(String name, String email, double balance) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }



    /**
     * Проверка текущего баланса
     */
    @Override
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public double chekBalanse() {
        return 0;
    }

    /**
     * Проверка, достаточно ли денег для покупки
     */
    @Override
    public boolean hasEnoughMoney(double amount) {
        return this.balance >= amount;
    }

    /**
     * Получение статуса клиента в зависимости от баланса
     */
    @Override
    public String getFinalStatus() {
        if (this.balance >= 1000) {
            return "VIP Клиент";
        } else if (this.balance >= 500) {
            return "Стандартный Клиент";
        } else {
            return "Новый Клиент";
        }
    }



    /**
     * Пополнение баланса
     */
    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Баланс пополнен на $" + amount);
        }
    }

    /**
     * Списание средств (только если хватает денег)
     */
    public void deductBalance(double amount) {
        if (hasEnoughMoney(amount)) {
            this.balance -= amount;
            System.out.println("С карты списано $" + amount);
        } else {
            System.out.println("Ошибка: Недостаточно средств!");
        }
    }



    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getBalance() { return balance; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setBalance(double balance) { this.balance = balance; }


    @Override
    public String toString() {
        return String.format("ID: %d | %s (%s) | Баланс: $%.2f | Статус: %s",
                id, name, email, balance, getFinalStatus());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id == client.id; // Сравниваем по уникальному ID
    }

    @Override
    public int hashCode() {
        return id;
    }
}



