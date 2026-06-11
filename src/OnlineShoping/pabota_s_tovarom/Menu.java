package OnlineShoping.pabota_s_tovarom;


import OnlineShoping.Category.GardenCategory;
import OnlineShoping.Client.Client;
import OnlineShoping.Transaktion.PaymentStrategy;
import OnlineShoping.Transaktion.PaymentContext;
import OnlineShoping.Category.Category;
import OnlineShoping.Exception.*;
import OnlineShoping.Product.Product;
import OnlineShoping.Product.ProductComparer;
import OnlineShoping.Product.ProductService;
import OnlineShoping.Tovary.Electronic;
import OnlineShoping.Tovary.GardenItem;
import OnlineShoping.Tovary.Laptop;
import OnlineShoping.Tovary.Phone;
import OnlineShoping.Transaktion.CardPaymentStrategy;
import OnlineShoping.Transaktion.CashPaymentStrategy;
import OnlineShoping.Zakaz.Order;
import OnlineShoping.Zakaz.OrderService;

import java.util.*;



public class Menu {
    private Scanner scanner;
    private Catalog catalog;
    private List<Product> allProducts;
    private List<Client> clients;
    private PaymentContext paymentContext;
    private OrderService orderService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.paymentContext = new PaymentContext();
        this.orderService = new OrderService(paymentContext);
        this.catalog = new Catalog("Главный Магазин");
        this.allProducts = new ArrayList<>();
        this.clients = new ArrayList<>();
        initTestData();
    }

    private void initTestData() {
        try {
            Category tech = new Electronic("Техника", "Гаджеты");
            Category garden = new GardenCategory("Сад", "Инструменты");

            catalog.addCategory(tech);
            catalog.addCategory(garden);

            Product p1 = new Phone("iPhone 15", 999, "Apple", "Apple", 4000);
            Product p2 = new Phone("Galaxy S24", 899, "Samsung", "Samsung", 4500);
            Product l1 = new Laptop("MacBook Air", 2000, "Apple", 16, "M3");
            Product g1 = new GardenItem("Лопата", 50, "Стальная", "Весна");

            allProducts.add(p1); allProducts.add(p2);
            allProducts.add(l1); allProducts.add(g1);

            clients.add(new Client("Алиса", 2000));
            clients.add(new Client("Борис", 500));

        } catch (CategoryLimitExceededException e) {
            System.err.println(" Критическая ошибка при инициализации: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }    }

    public void start() {
        boolean running = true;

        while (running) {
            try {
                printMenu();
                int choice = getValidIntInput();

                switch (choice) {
                    case 1:
                        showCatalog();
                        break;
                    case 2:
                        sortMenu();
                        break;
                    case 3:
                        compareMenu();
                        break;
                    case 4:
                        searchMenu();
                        break;
                    case 5:
                        filterMenu();
                        break;
                    case 6:
                        createOrderMenu();
                        break;
                    case 7:
                        transferMenu();
                        break;
                    case 0:
                        running = false;
                        System.out.println(" До свидания!");
                        break;
                    default:
                        System.out.println("️ Неверный выбор. Попробуйте снова.");
                }

            } catch (Exception e) {
                System.err.println("\n Произошла ошибка: " + e.getMessage());
                System.err.println(" Программа продолжает работу...\n");
                // Логирование ошибки (опционально)
                // e.printStackTrace();
            } finally {
                // Очистка или финальные действия после каждой итерации
                System.out.println();
            }
        }

        // Закрытие ресурсов

        try {
            if (scanner != null) {
                scanner.close();
                System.out.println(" Ресурсы освобождены");
            }
        } catch (Exception e) {
            System.err.println("️ Ошибка при закрытии: " + e.getMessage());
        }
    }

    private void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("          ГЛАВНОЕ МЕНЮ");
        System.out.println("=".repeat(50));
        System.out.println("1.  Каталог и статистика");
        System.out.println("2.  Сортировка товаров");
        System.out.println("3.  Сравнение товаров");
        System.out.println("4.  Поиск товара");
        System.out.println("5.  Фильтрация по цене");
        System.out.println("6.  Оформить заказ");
        System.out.println("7.  Перевод средств");
        System.out.println("0.  Выход");
        System.out.println("=".repeat(50));
        System.out.print("Выберите пункт: ");
    }

    private int getValidIntInput() {
        while (!scanner.hasNextInt()) {
            String invalid = scanner.next();
            System.err.println(" '" + invalid + "' - не является числом! Введите целое число: ");
        }
        return scanner.nextInt();
    }

    private void searchMenu() {
        System.out.print(" Введите название товара: ");
        scanner.nextLine(); // Очистка буфера
        String query = scanner.nextLine();

        try {
            Product found = ProductService.findProductByName(allProducts, query);
            if (found != null) {
                System.out.println(" Товар найден успешно!");
            }
        } catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
            System.out.println(" Подсказка: попробуйте ввести часть названия");
        } catch (IllegalArgumentException e) {
            System.err.println(" Ошибка ввода: " + e.getMessage());
        }
    }

    private void filterMenu() {
        try {
            System.out.print(" Минимальная цена: ");
            double min = scanner.nextDouble();

            System.out.print(" Максимальная цена: ");
            double max = scanner.nextDouble();
            ProductService.filterByPriceRange(allProducts, min, max);

        } catch (IllegalArgumentException e) {
            System.err.println(" " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Ошибка фильтрации: " + e.getMessage());
        }
    }

    private void createOrderMenu() {
        System.out.println("\n Оформление заказа");

        try {
            System.out.println("Выберите способ оплаты:");
            System.out.println("1. Наличные");
            System.out.println("2. Карта");
            int payChoice = getValidIntInput();

            PaymentStrategy strategy;
            if (payChoice == 1) {
                strategy = new CashPaymentStrategy();
            } else if (payChoice == 2) {
                System.out.print("Введите номер карты (16 цифр): ");
                String cardNum = scanner.next();
                if (cardNum.length() != 16) {
                    throw new IllegalArgumentException(" Номер карты должен содержать 16 цифр!");
                }
                strategy = new CardPaymentStrategy(cardNum);
            } else {
                throw new IllegalArgumentException(" Неверный способ оплаты!");
            }

            System.out.println("Добавьте товары (номера через пробел, 0 для завершения):");
            List<Product> cart = new ArrayList<>();

            while (true) {
                int idx = getValidIntInput();
                if (idx == 0) break;

                if (idx > 0 && idx <= allProducts.size()) {
                    cart.add(allProducts.get(idx - 1));
                } else {
                    System.err.println("️ Неверный номер товара!");
                }
            }

            if (cart.isEmpty()) {
                throw new IllegalStateException(" Корзина пуста!");
            }
            System.out.print("Имя клиента: ");
            scanner.nextLine();
            String clientName = scanner.nextLine();

            if (clientName.trim().isEmpty()) {
                throw new IllegalArgumentException(" Имя клиента не может быть пустым!");
            }

            Order order = orderService.createAndPayOrder(clientName, cart, strategy);

            if (order != null) {
                System.out.println(" Заказ успешно оформлен!");
                order.printHistory();
            }

        } catch (InsufficientFundsException | PaymentFailedException |
                 CreditLimitExceededException e) {
            System.err.println(" Ошибка при оплате: " + e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println(" Ошибка ввода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void transferMenu() {
        System.out.println("\n Перевод средств между клиентами");

        try {
            if (clients.size() < 2) {
                throw new IllegalStateException(" Недостаточно клиентов для перевода!");
            }

            System.out.println("Доступные клиенты:");
            for (int i = 0; i < clients.size(); i++) {
                Client c = clients.get(i);
                System.out.println((i + 1) + ". " + c.getName() + " (Баланс: $" + c.checkBalance() + ")");
            }

            System.out.print("От кого (номер): ");
            int fromIdx = getValidIntInput() - 1;

            System.out.print("Кому (номер): ");
            int toIdx = getValidIntInput() - 1;

            if (fromIdx < 0 || fromIdx >= clients.size() ||
                    toIdx < 0 || toIdx >= clients.size()) {
                throw new IllegalArgumentException(" Неверный номер клиента!");
            }
            if (fromIdx == toIdx) {
                throw new IllegalArgumentException(" Нельзя перевести средства самому себе!");
            }

            System.out.print("Сумма перевода: $");
            double amount = scanner.nextDouble();

            Client sender = clients.get(fromIdx);
            Client recipient = clients.get(toIdx);

            sender.transferTo(recipient, amount);

        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
            System.out.println(" Недостаточно средств: " + e.getShortfall());
        } catch (InvalidTransferAmountException e) {
            System.err.println(" " + e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println(" " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Ошибка перевода: " + e.getMessage());
        }
    }

    // ... остальные методы (showCatalog, sortMenu, compareMenu и т.д.)
    // с аналогичной обработкой исключений

    private void showCatalog() {
        try {
            catalog.showStatistics();
        } catch (Exception e) {
            System.err.println(" Ошибка при показе каталога: " + e.getMessage());
        }
    }

    private void sortMenu() {
        try {
            System.out.println("1. По цене (возр.)");
            System.out.println("2. По цене (убыв.)");
            int choice = getValidIntInput();

            if (choice == 1) {
                Collections.sort(allProducts);
            } else if (choice == 2) {
                Collections.sort(allProducts, Comparators.byPriceDesc());
            } else {
                throw new IllegalArgumentException("Неверный выбор!");
            }
            System.out.println(" Отсортировано:");
            allProducts.forEach(Product::showInfo);

        } catch (IllegalArgumentException e) {
            System.err.println(" " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Ошибка сортировки: " + e.getMessage());
        }
    }

    private void compareMenu() {
        try {
            System.out.println("Выберите товары для сравнения:");
            for (int i = 0; i < allProducts.size(); i++) {
                System


                        .out.println((i + 1) + ". " + allProducts.get(i).getTitle());
            }

            System.out.print("Товар #1: ");
            int i1 = getValidIntInput() - 1;

            System.out.print("Товар #2: ");
            int i2 = getValidIntInput() - 1;

            if (i1 < 0 || i1 >= allProducts.size() ||
                    i2 < 0 || i2 >= allProducts.size()) {
                throw new IllegalArgumentException("Неверный номер товара!");
            }

            Product p1 = allProducts.get(i1);
            Product p2 = allProducts.get(i2);

            if (ProductComparer.canCompare(p1, p2)) {
                ProductComparer.compare(p1, p2);
            } else {
                System.err.println(" Нельзя сравнивать разные типы товаров!");
            }

        } catch (IllegalArgumentException e) {
            System.err.println(" " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Ошибка сравнения: " + e.getMessage());
        }
    }
}