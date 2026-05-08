package OnlineShoping;


import java.util.*;
import java.util.stream.Collectors;


public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Catalog catalog = new Catalog("Main Store");
    private List<Product> allProducts = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Menu() {
        // Инициализация данных
        Category tech = new Electronic("Tech", "Gadgets");
        Category garden = new GardenCategory("Garden", "Tools");

        catalog.addCategory(tech);
        catalog.addCategory(garden);

        Product p1 = new Phone("iPhone 15", 999, "Apple", "Apple", 4000);
        Product p2 = new Phone("S24", 899, "Samsung", "Samsung", 4500);
        Product l1 = new Laptop("MacBook", 2000, "Apple", 16, "M3");
        Product l2 = new Laptop("Dell", 1500, "Windows", 32, "i7");
        Product g1 = new GardenItem("Shovel", 50, "Steel", "Spring");

        allProducts.add(p1); allProducts.add(p2);
        allProducts.add(l1); allProducts.add(l2);
        allProducts.add(g1);

        tech.addProduct(l1); tech.addProduct(l2);
        garden.addProduct(g1);

        clients.add(new Client("Alice", 2000));
        clients.add(new Client("Bob", 500));
    }

    public void start() {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Каталог");
            System.out.println("2. Сортировка товаров");
            System.out.println("3. Сравните товары");
            System.out.println("4. Аналитика (Stream + Lambda)");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: catalog.showStatistics(); break;
                case 2: sortMenu(); break;
                case 3: compareMenu(); break;
                case 4: analyticsMenu(); break;
                case 0: return;
            }
        }
    }

    // 2. Сортировка с Comparator и Comparable
    private void sortMenu() {
        System.out.println("1. Цена (по возрастанию) [Сравнимая]");
        System.out.println("2. Цена (Описание) [Сравнительный инструмент]");
        System.out.println("3. ОЗУ [Компаратор]");
        int c = scanner.nextInt();

        if (c == 1) Collections.sort(allProducts); // Comparable
        else if (c == 2) Collections.sort(allProducts, Comparators.byPriceDesc());
        else if (c == 3) Collections.sort(allProducts, Comparators.byRam());

        System.out.println("Сортировано:");
        for (Product p : allProducts) p.showInfo();
    }

    // 3. Сравнение по номерам с защитой
    private void compareMenu() {
        System.out.println("Выберите товары по номеру:");
        for (int i = 0; i < allProducts.size(); i++) {
            System.out.println((i + 1) + ". " + allProducts.get(i).getTitle());
        }

        System.out.print("Первый #: ");
        int idx1 = scanner.nextInt() - 1;
        System.out.print("Второй #: ");
        int idx2 = scanner.nextInt() - 1;

        if (idx1 >= 0 && idx1 < allProducts.size() && idx2 >= 0 && idx2 < allProducts.size()) {
            Product p1 = allProducts.get(idx1);
            Product p2 = allProducts.get(idx2);

            if (ProductComparer.canCompare(p1, p2)) {
                ProductComparer.compare(p1, p2);
            } else {
                System.out.println(" Сравнивать разные типы невозможно!");
            }
        }
    }

    // 4. Аналитика: Stream API, Lambda, Enum
    private void analyticsMenu() {
        System.out.println("--- Аналитика ---");
        // Создаем заказы
        List<Order> orders = List.of(
                new Order("iPhone", 999, OrderStatus.PAID),
                new Order("MacBook", 2000, OrderStatus.CREATED),
                new Order("Shovel", 50, OrderStatus.PAID),
                new Order("S24", 899, OrderStatus.PAID)
        );

        // Lambda реализация функционального интерфейса
        StatusChecker isExpensivePaid = (status, amount) -> status == OrderStatus.PAID && amount > 100;

        // Stream API: Фильтруем заказы через Lambda
        List<String> expensivePaid = orders.stream()
                .filter(o -> isExpensivePaid.check(o.getStatus(), o.getAmount()))
                .map(o -> " " + o.getProductName() + " ($" + o.getAmount() + ")")
                .collect(Collectors.toList());

        System.out.println("Дорогие платные заказы:");
        expensivePaid.forEach(System.out::println);

        // Группировка по перечислению
        System.out.println("Заказы по статусу:");
        orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k.getLabel() + ": " + v));
    }
}
