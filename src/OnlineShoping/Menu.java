package OnlineShoping;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


    public class Menu {
        private Scanner scanner;
        private Catalog catalog;
        private ArrayList<Product> allProducts; // Плоский список для быстрого доступа
        private ArrayList<Client> clients;

        public Menu() {
            this.scanner = new Scanner(System.in);
            this.catalog = new Catalog("ТехноСад 2026", 0.0);
            this.allProducts = new ArrayList<>();
            this.clients = new ArrayList<>();

            initTestData();
        }

        /**
         * Заполнение тестовыми данными
         */
        private void initTestData() {
            // Категории
            Category electronics = new Electronic("Электроника", "Гаджеты и компьютеры");
            Category garden = new GardenCategory("Сад и Огород", "Инструменты и уход");
            Category phones = new MobileDevice("Смартфоны", "Мобильные устройства");

            electronics.addCategory(phones);

            // Продукты
            Product p1 = new Phone("iPhone 15", 999.0, "Apple", "Apple", 4000);
            Product p2 = new Phone("Samsung S24", 899.0, "Android", "Samsung", 4500);
            Product p3 = new Phone("Pixel 8", 699.0, "Google", "Google", 4200);

            Product l1 = new Laptop("MacBook Air", 1299.0, "Apple", 8, "M2");
            Product l2 = new Laptop("Dell XPS", 1599.0, "Windows", 16, "Intel i7");

            Product g1 = new GardenItem("Лопата", 25.0, "Сталь", "Весна-Осень", "Steel");
            Product g2 = new GardenItem("Секатор", 40.0, "Для веток", "Круглый год", "Steel");
            // Распределение
            phones.addProduct(p1);
            phones.addProduct(p2);
            phones.addProduct(p3);
            electronics.addProduct(l1);
            electronics.addProduct(l2);
            garden.addProduct(g1);
            garden.addProduct(g2);

            catalog.addCategory(electronics);
            catalog.addCategory(garden);

            // Плоский список для меню сравнения и сортировки
            Collections.addAll(allProducts, p1, p2, p3, l1, l2, g1, g2);

            // Клиенты
            clients.add(new Client("Иван Петров", "ivan@mail.ru", 2500.0));
            clients.add(new Client("Ольга Смирнова", "olga@mail.ru", 800.0));
        }

        /**
         * Запуск главного цикла
         */
        public void start() {
            boolean exit = false;
            while (!exit) {
                printHeader("ГЛАВНОЕ МЕНЮ");
                System.out.println("1. Показать каталог");
                System.out.println("2. Статистика (счетчики)");
                System.out.println("3. Сортировка товаров");
                System.out.println("4. Сравнение товаров (по номерам)");
                System.out.println("5. Клиенты (баланс)");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт: ");

                int choice = getIntInput();
                switch (choice) {
                    case 1: showCatalog(); break;
                    case 2: showStats(); break;
                    case 3: showSortMenu(); break;
                    case 4: showCompareMenu(); break; // <-- НОВЫЙ МЕТОД СРАВНЕНИЯ
                    case 5: showClientMenu(); break;
                    case 0: exit = true; System.out.println(" До свидания!"); break;
                    default: System.out.println("Неверный пункт.");
                }
                pause();
            }
        }


        private void showCompareMenu() {
            printHeader("СРАВНЕНИЕ ТОВАРОВ");
            System.out.println("Доступные товары (выберите номер):");
            System.out.println("-".repeat(50));

            // 1. Выводим список с цифрами
            for (int i = 0; i < allProducts.size(); i++) {
                Product p = allProducts.get(i);
                String type = "";
                if (p instanceof Phone) type = " Телефон";
            else if (p instanceof Laptop) type = "💻 Ноутбук";
                else if (p instanceof GardenItem) type = "🌱 Сад";

                System.out.printf("%d. %-15s | %s | $%.2f%n",
                        i + 1, p.getTitle(), type, p.getPrice());
            }
            System.out.println("-".repeat(50));

            // 2. Запрашиваем первый номер
            System.out.print("Введите номер первого товара: ");
            int num1 = getIntInput();

            // 3. Запрашиваем второй номер
            System.out.print("Введите номер второго товара: ");
            int num2 = getIntInput();

            // 4. Валидация ввода
            if (num1 < 1 || num1 > allProducts.size() || num2 < 1 || num2 > allProducts.size()) {
                System.out.println("\nОшибка: Номер выходит за пределы списка!");
                return;
            }

            if (num1 == num2) {
                System.out.println("\nОшибка: Нельзя сравнить товар с самим собой!");
                return;
            }

            // 5. Получаем объекты (корректируем индекс с 1-based на 0-based)
            Product p1 = allProducts.get(num1 - 1);
            Product p2 = allProducts.get(num2 - 1);

            // 6. ЗАЩИТА: Проверка сегментов
            if (!ProductComparer.canCompare(p1, p2)) {
                System.out.println("\nОШИБКА: Разные категории!");
                System.out.println(" Товар №" + num1 + ": " + ProductComparer.getProductType(p1));
                System.out.println("Товар №" + num2 + ": " + ProductComparer.getProductType(p2));
                System.out.println("Сравнивайте только товары одного типа (например, Телефон с Телефоном).");
                return;        }

            // 7. Запускаем детальное сравнение
            System.out.println("\n🔍 Результат сравнения:");
            ProductComparer.compare(p1, p2);
        }


        private void showCatalog() {
            printHeader(" КАТАЛОГ");
            catalog.showCategory();
        }

        private void showStats() {
            printHeader("СТАТИСТИКА");
            catalog.showStatistics();
        }

        private void showSortMenu() {
            printHeader("CОРТИРОВКА");
            System.out.println("1. По цене (возрастание)");
            System.out.println("2. По цене (убывание)");
            System.out.println("3. По названию (А-Я)");
            System.out.println("4. По RAM (только ноутбуки)");
            System.out.println("5. По сезону (только сад)");
            System.out.print("Выберите критерий: ");

            int choice = getIntInput();
            try {
                switch (choice) {
                    case 1: Collections.sort(allProducts); break; // Comparable
                    case 2: Collections.sort(allProducts, Comparators.byPriceDescending()); break;
                    case 3: Collections.sort(allProducts, Comparators.byTitle()); break;
                    case 4: Collections.sort(allProducts, Comparators.byRam()); break;
                    case 5: Collections.sort(allProducts, Comparators.bySeason()); break;
                    default: System.out.println("️ Неверный выбор."); return;
                }
                printProductList("Отсортировано:", allProducts);
            } catch (Exception e) {
                System.out.println("Ошибка сортировки: " + e.getMessage());
            }
        }

        private void showClientMenu() {
            printHeader("👤 КЛИЕНТЫ");
            for (int i = 0; i < clients.size(); i++) {
                Client c = clients.get(i);
                System.out.printf("%d. %-15s | Баланс: $%-8.2f | Статус: %s%n",                i + 1, c.getName(), c.checkBalance(), c.getFinalStatus());
            }
            System.out.print("\nВведите номер клиента для проверки баланса: ");
            int idx = getIntInput() - 1;
            if (idx >= 0 && idx < clients.size()) {
                Client c = clients.get(idx);
                System.out.print("Сумма покупки: ");
                double sum = scanner.nextDouble();
                if (c.hasEnoughMoney(sum)) {
                    System.out.println("Достаточно средств. Списано: $" + sum);
                    c.deductBalance(sum);
                } else {
                    System.out.println("Недостаточно средств!");
                }
            }
        }


        private void printHeader(String title) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("   " + title);
            System.out.println("=".repeat(60));
        }

        private void printProductList(String header, ArrayList<Product> list) {
            printHeader(header);
            for (int i = 0; i < list.size(); i++) {
                Product p = list.get(i);
                System.out.printf("%d. %-15s | $%.2f%n", i + 1, p.getTitle(), p.getPrice());
            }
        }

        private int getIntInput() {
            while (!scanner.hasNextInt()) {
                System.out.print("Введите целое число: ");
                scanner.next();
            }
            int val = scanner.nextInt();
            scanner.nextLine(); // очистка Enter
            return val;
        }

        private void pause() {
            System.out.print("\nНажмите Enter...");
            scanner.nextLine();
        }
    }
