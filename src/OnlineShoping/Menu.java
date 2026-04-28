package OnlineShoping;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Menu {
    private Scanner scanner;
    private Catalog catalog;
    private ArrayList<Product> allProducts; // Плоский список всех продуктов для удобства
    private ArrayList<Client> clients;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.catalog = new Catalog("Главный Каталог 2026", 0.0);
        this.allProducts = new ArrayList<>();
        this.clients = new ArrayList<>();

        initializeTestData();
    }

    /**
     * Заполнение каталога начальными данными для демонстрации
     */
    private void initializeTestData() {
        // 1. Создаем категории
        Category electronics = new Electronic("Электроника", "Гаджеты и устройства");
        Category garden = new GardenCategory("Садовые товары", "Инструменты и растения");

        // Подкатегория для электроники
        Category mobile = new MobileDevice("Смартфоны", "Мобильные телефоны");
        electronics.addCategory(mobile);

        // 2. Создаем продукты
        // Телефоны
        Product p1 = new Phone("iPhone 15 Pro", 999.0, "Apple Flagship", "Apple", 4000);
        Product p2 = new Phone("Samsung S24 Ultra", 1199.0, "Android Flagship", "Samsung", 5000);
        Product p3 = new Phone("Pixel 8", 699.0, "Google Camera", "Google", 4200);

        // Ноутбуки
        Product l1 = new Laptop("MacBook Air M3", 1299.0, "Lightweight Apple", 8, "M3");        Product l2 = new Laptop("Dell XPS 15", 1899.0, "Windows Premium", 32, "Intel i7");
        Product l3 = new Laptop("Lenovo ThinkPad", 1100.0, "Business Class", 16, "AMD Ryzen");

        // Садовые товары
        Product g1 = new GardenItem("Лопата Штыковая", 25.0, "Стальная лопата", "Весна-Осень", "Steel");
        Product g2 = new GardenItem("Грабли Веерные", 15.0, "Для листьев", "Весна-Осень", "Plastic");
        Product g3 = new GardenItem("Секатор Профи", 45.0, "Для обрезки веток", "Круглый год", "Steel");

        // 3. Добавляем продукты в соответствующие категории
        mobile.addProduct(p1);
        mobile.addProduct(p2);
        mobile.addProduct(p3);

        electronics.addProduct(l1);
        electronics.addProduct(l2);
        electronics.addProduct(l3);

        garden.addProduct(g1);
        garden.addProduct(g2);
        garden.addProduct(g3);

        // 4. Добавляем категории в каталог
        catalog.addCategory(electronics);
        catalog.addCategory(garden);

        // 5. Заполняем плоский список всех продуктов (для сортировки и сравнения)
        allProducts.add(p1); allProducts.add(p2); allProducts.add(p3);
        allProducts.add(l1); allProducts.add(l2); allProducts.add(l3);
        allProducts.add(g1); allProducts.add(g2); allProducts.add(g3);

        // 6. Создаем клиентов
        clients.add(new Client("Иван Иванов", "ivan@mail.ru", 5000.0));
        clients.add(new Client("Петр Петров", "petr@mail.ru", 1200.0));
        clients.add(new Client("Анна Сидорова", "anna@mail.ru", 300.0));
    }

    /**
     * Главный цикл меню
     */
    public void start() {
        boolean exit = false;
        while (!exit) {
            printHeader("ГЛАВНОЕ МЕНЮ");
            System.out.println("1. Показать весь каталог (иерархия)");
            System.out.println("2. Статистика каталога (счетчики)");
            System.out.println("3. Сортировка всех товаров");
            System.out.println("4. Сравнение двух товаров");
            System.out.println("5. Работа с клиентами (Финансы)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = getIntInput();
            switch (choice) {

                case 1:
                    showFullCatalog();
                    break;
                case 2:
                    showStatistics();
                    break;
                case 3:
                    showSortMenu();
                    break;
                case 4:
                    showCompareMenu();
                    break;
                case 5:
                    showClientMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            waitForEnter();
        }
    }


    private void showFullCatalog() {
        printHeader("ПОЛНЫЙ КАТАЛОГ");
        catalog.showCategory();
    }

    private void showStatistics() {
        printHeader("СТАТИСТИКА");
        catalog.showStatistics();
    }



    private void showSortMenu() {
        printHeader("СОРТИРОВКА ТОВАРОВ");
        System.out.println("1. По цене (возрастание) - [Comparable]");        System.out.println("2. По цене (убывание) - [Comparator]");
        System.out.println("3. По названию (А-Я) - [Comparator]");
        System.out.println("4. По RAM (только ноутбуки) - [Comparator]");
        System.out.println("5. По сезону (только сад) - [Comparator]");
        System.out.println("6. По бренду (только телефоны) - [Comparator]");
        System.out.println("0. Назад");
        System.out.print("Выберите критерий: ");

        int choice = getIntInput();
        if (choice == 0) return;

        Comparator<Product> comparator = null;
        try {
            switch (choice) {
                case 1:
                    // Использует метод compareTo из класса Product (Comparable)
                    Collections.sort(allProducts);
                    break;
                case 2:
                    comparator = Comparators.byPriceDescending();
                    break;
                case 3:
                    comparator = Comparators.byTitle();
                    break;
                case 4:
                    comparator = Comparators.byRam();
                    break;
                case 5:
                    comparator = Comparators.bySeason();
                    break;
                case 6:
                    comparator = Comparators.byBrand();
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    return;
            }

            // Если выбран компаратор (не случай 1), применяем его
            if (comparator != null) {
                Collections.sort(allProducts, comparator);
            }

            printProductList("Отсортированный список:", allProducts);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка сортировки: " + e.getMessage());
        }
    }


    private void showCompareMenu() {
        printHeader("СРАВНЕНИЕ ТОВАРОВ");

        // Выводим нумерованный список всех товаров
        for (int i = 0; i < allProducts.size(); i++) {
            Product p = allProducts.get(i);
            String type = "";
            if (p instanceof Phone) type = "[Телефон]";
            else if (p instanceof Laptop) type = "[Ноутбук]";
            else if (p instanceof GardenItem) type = "[Сад]";

            System.out.printf("%d. %-20s %s ($%.2f)%n",
                    i + 1, p.getTitle(), type, p.getPrice());
        }


        System.out.print("\nВыберите номер первого товара: ");
        int idx1 = getIntInput() - 1;

        System.out.print("Выберите номер второго товара: ");
        int idx2 = getIntInput() - 1;

        // Проверка границ массива
        if (idx1 < 0 || idx1 >= allProducts.size() || idx2 < 0 || idx2 >= allProducts.size()) {
            System.out.println("Ошибка: Неверный номер товара.");
            return;
        }

        Product p1 = allProducts.get(idx1);
        Product p2 = allProducts.get(idx2);

        // ЗАЩИТА: Проверка на один сегмент перед сравнением
        if (!ProductComparer.canCompare(p1, p2)) {
            System.out.println("\nОШИБКА БЕЗОПАСНОСТИ ");
            System.out.println("Нельзя сравнивать товары из разных сегментов!");
            System.out.println("Товар 1: " + ProductComparer.getProductType(p1));
            System.out.println("Товар 2: " + ProductComparer.getProductType(p2));
            return;
        }

        // Если типы совпадают, запускаем детальное сравнение
        ProductComparer.compare(p1, p2);
    }


    private void showClientMenu() {
        printHeader("КЛИЕНТЫ И ФИНАНСЫ");
        System.out.println("Список клиентов:");
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            System.out.printf("%d. %-15s Баланс: $%-8.2f Статус: %s%n",
                    i + 1, c.getName(), c.checkBalance(), c.getFinalStatus());
        }

        System.out.print("\nВыберите клиента (номер): ");
        int clientIdx = getIntInput() - 1;

        if (clientIdx < 0 || clientIdx >= clients.size()) {
            System.out.println("Неверный номер клиента.");
            return;
        }

        Client selectedClient = clients.get(clientIdx);

        System.out.print("Введите сумму для проверки наличия средств: ");
        double amount = getDoubleInput();

        System.out.println("\nПроверка баланса:");
        System.out.println("Текущий баланс: $" + selectedClient.checkBalance());

        if (selectedClient.hasEnoughMoney(amount)) {
            System.out.println("Денег достаточно!");
            System.out.print("Списать средства? (1 - Да, 0 - Нет): ");
            if (getIntInput() == 1) {
                selectedClient.deductBalance(amount);
                System.out.println("Новый баланс: $" + selectedClient.checkBalance());
            }
        } else {
            System.out.println("Недостаточно средств!");
            System.out.println("Не хватает: $" + (amount - selectedClient.checkBalance()));
        }
    }



    private void printHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("   " + title);
        System.out.println("=".repeat(50));
    }

    private void printProductList(String header, ArrayList<Product> list) {        printHeader(header);
        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);
            String extraInfo = "";
            if (p instanceof Laptop) extraInfo = " | RAM: " + ((Laptop)p).getRam() + "GB";
            if (p instanceof Phone) extraInfo = " | Batt: " + ((Phone)p).getBatteryCapacity() + "mAh";
            if (p instanceof GardenItem) extraInfo = " | Season: " + ((GardenItem)p).getSeason();

            System.out.printf("%d. %-20s $%-8.2f %s%n",
                    i + 1, p.getTitle(), p.getPrice(), extraInfo);
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Пожалуйста, введите целое число: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // очистка буфера


        return val;
    }

    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Пожалуйста, введите число: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    private void waitForEnter() {
        System.out.print("\nНажмите Enter для продолжения...");
        try {
            scanner.nextLine();
        } catch (Exception e) {}
    }
}
