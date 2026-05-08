package OnlineShoping;

public class Client implements Finansible {
    private String name;
    private double balance;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public double checkBalance() { return balance; }

    @Override
    public boolean hasEnoughMoney(double amount) { return balance >= amount; }

    @Override
    public String getFinalStatus() {
        if (balance > 1000) return "VIP";
        if (balance > 500) return "Standard";
        return "New";
    }

    public void buy(Product product) {
        if (hasEnoughMoney(product.getFinalPrice())) {
            balance -= product.getFinalPrice();
            product.pay(product.getFinalPrice());
            System.out.println(" Списано с баланса клиента " + name);
        } else {
            System.out.println(" У клиента " + name + " нет денег.");
        }
    }

    public String getName() { return name; }
}



