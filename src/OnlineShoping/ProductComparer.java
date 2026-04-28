package OnlineShoping;

public class ProductComparer {

    /**
     * Сравнение двух продуктов с выводом всех различий
     */
    public static void compare(Product p1, Product p2) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("           СРАВНЕНИЕ ПРОДУКТОВ");
        System.out.println("=".repeat(70));


        if (!canCompare(p1, p2)) {
            System.out.println("ВНИМАНИЕ: Продукты из разных сегментов!");
            System.out.println("  Продукт 1: " + getProductType(p1));
            System.out.println("  Продукт 2: " + getProductType(p2));
            System.out.println("  Рекомендуется сравнивать продукты одного типа!");
            System.out.println("=".repeat(70));
        }


        System.out.println("\n--- ОБЩАЯ ИНФОРМАЦИЯ ---");
        System.out.println("Продукт 1: " + p1.getTitle());
        System.out.println("  Тип: " + getProductType(p1));
        System.out.println("  Цена: $" + p1.getFinalPrice());
        System.out.println("  Описание: " + p1.getDescription());

        System.out.println("\nПродукт 2: " + p2.getTitle());
        System.out.println("  Тип: " + getProductType(p2));
        System.out.println("  Цена: $" + p2.getFinalPrice());
        System.out.println("  Описание: " + p2.getDescription());


        System.out.println("\n--- СРАВНЕНИЕ ПО ЦЕНЕ ---");
        compareByPrice(p1, p2);


        System.out.println("\n--- СРАВНЕНИЕ ПО НАЗВАНИЮ ---");
        compareByTitle(p1, p2);


        if (p1 instanceof Phone && p2 instanceof Phone) {
            comparePhones((Phone) p1, (Phone) p2);
        }

        if (p1 instanceof Laptop && p2 instanceof Laptop) {
            compareLaptops((Laptop) p1, (Laptop) p2);        }

        if (p1 instanceof GardenItem && p2 instanceof GardenItem) {
            compareGardenItems((GardenItem) p1, (GardenItem) p2);
        }


        System.out.println("\n--- ИТОГ ---");
        if (p1.getFinalPrice() < p2.getFinalPrice()) {
            System.out.println("✓ ВЫГОДНЕЕ: " + p1.getTitle() + " (дешевле на $" +
                    (p2.getFinalPrice() - p1.getFinalPrice()) + ")");
        } else if (p2.getFinalPrice() < p1.getFinalPrice()) {
            System.out.println("✓ ВЫГОДНЕЕ: " + p2.getTitle() + " (дешевле на $" +
                    (p1.getFinalPrice() - p2.getFinalPrice()) + ")");
        } else {
            System.out.println("= Цены одинаковые");
        }

        System.out.println("=".repeat(70));
    }

    /**
     * Сравнение по цене
     */
    public static void compareByPrice(Product p1, Product p2) {
        double price1 = p1.getFinalPrice();
        double price2 = p2.getFinalPrice();
        double diff = Math.abs(price1 - price2);

        System.out.println("Цена продукта 1: $" + price1);
        System.out.println("Цена продукта 2: $" + price2);
        System.out.println("Разница: $" + diff);

        if (price1 > price2) {
            System.out.println("→ " + p1.getTitle() + " дороже на $" + (price1 - price2));
        } else if (price2 > price1) {
            System.out.println("→ " + p2.getTitle() + " дороже на $" + (price2 - price1));
        } else {
            System.out.println("→ Цены равны");
        }
    }

    /**
     * Сравнение по названию (алфавитный порядок)
     */
    public static void compareByTitle(Product p1, Product p2) {
        int result = p1.getTitle().compareToIgnoreCase(p2.getTitle());

        System.out.println("Название 1: " + p1.getTitle());
        System.out.println("Название 2: " + p2.getTitle());
        if (result < 0) {
            System.out.println("→ '" + p1.getTitle() + "' идёт раньше в алфавите");
        } else if (result > 0) {
            System.out.println("→ '" + p2.getTitle() + "' идёт раньше в алфавите");
        } else {
            System.out.println("→ Названия одинаковые");
        }
    }

    /**
     * Сравнение телефонов
     */
    public static void comparePhones(Phone ph1, Phone ph2) {
        System.out.println("\n--- СРАВНЕНИЕ ТЕЛЕФОНОВ ---");


        System.out.println("Бренд 1: " + ph1.getBrand());
        System.out.println("Бренд 2: " + ph2.getBrand());
        if (!ph1.getBrand().equals(ph2.getBrand())) {
            System.out.println("→ Разные производители");
        } else {
            System.out.println("→ Одинаковый производитель");
        }


        int batt1 = ph1.getBatteryCapacity();
        int batt2 = ph2.getBatteryCapacity();
        System.out.println("\nБатарея 1: " + batt1 + " mAh");
        System.out.println("Батарея 2: " + batt2 + " mAh");

        if (batt1 > batt2) {
            System.out.println("→ " + ph1.getTitle() + " имеет батарею больше на " + (batt1 - batt2) + "mAh");
        } else if (batt2 > batt1) {
            System.out.println("→ " + ph2.getTitle() + " имеет батарею больше на " + (batt2 - batt1) + "mAh");
        } else {
            System.out.println("→ Ёмкость батареи одинаковая");
        }


        double ratio1 = ph1.getFinalPrice() / batt1;
        double ratio2 = ph2.getFinalPrice() / batt2;
        System.out.println("\nЦена за 1 mAh:");
        System.out.println(ph1.getTitle() + ": $" + String.format("%.3f", ratio1));
        System.out.println(ph2.getTitle() + ": $" + String.format("%.3f", ratio2));

        if (ratio1 < ratio2) {
            System.out.println("→ " + ph1.getTitle() + " выгоднее по соотношению цена/батарея");
        } else {
            System.out.println("→ " + ph2.getTitle() + " выгоднее по соотношению цена/батарея");        }
    }

    /**
     * Сравнение ноутбуков
     */
    public static void compareLaptops(Laptop l1, Laptop l2) {
        System.out.println("\n--- СРАВНЕНИЕ НОУТБУКОВ ---");


        int ram1 = l1.getRam();
        int ram2 = l2.getRam();
        System.out.println("RAM 1: " + ram1 + " GB");
        System.out.println("RAM 2: " + ram2 + " GB");

        if (ram1 > ram2) {
            System.out.println("→ " + l1.getTitle() + " имеет RAM больше на " + (ram1 - ram2) + "GB");
        } else if (ram2 > ram1) {
            System.out.println("→ " + l2.getTitle() + " имеет RAM больше на " + (ram2 - ram1) + "GB");
        } else {
            System.out.println("→ Объём RAM одинаковый");
        }


        System.out.println("\nПроцессор 1: " + l1.getProcessor());
        System.out.println("Процессор 2: " + l2.getProcessor());


        double pricePerRam1 = l1.getFinalPrice() / ram1;
        double pricePerRam2 = l2.getFinalPrice() / ram2;
        System.out.println("\nЦена за 1 GB RAM:");
        System.out.println(l1.getTitle() + ": $" + String.format("%.2f", pricePerRam1));
        System.out.println(l2.getTitle() + ": $" + String.format("%.2f", pricePerRam2));

        if (pricePerRam1 < pricePerRam2) {
            System.out.println("→ " + l1.getTitle() + " выгоднее по цене за GB RAM");
        } else {
            System.out.println("→ " + l2.getTitle() + " выгоднее по цене за GB RAM");
        }
    }

    /**
     * Сравнение садовых товаров
     */
    public static void compareGardenItems(GardenItem g1, GardenItem g2) {
        System.out.println("\n--- СРАВНЕНИЕ САДОВЫХ ТОВАРОВ ---");


        System.out.println("Сезон 1: " + g1.getSeason());
        System.out.println("Сезон 2: " + g2.getSeason());

        System.out.println("\nМатериал 1: " + g1.getMaterial());
        System.out.println("Материал 2: " + g2.getMaterial());

        if (g1.getMaterial().equals(g2.getMaterial())) {
            System.out.println("→ Одинаковый материал");
        } else {
            System.out.println("→ Разные материалы");
        }
    }

    /**
     * Проверка: можно ли сравнивать продукты
     */
    public static boolean canCompare(Product p1, Product p2) {
        return p1.getClass().equals(p2.getClass());
    }

    /**
     * Получение типа продукта
     */
    public static String getProductType(Product p) {
        if (p instanceof Phone) return "Телефон";
        if (p instanceof Laptop) return "Ноутбук";
        if (p instanceof GardenItem) return "Садовый товар";
        return "Продукт";
    }

    /**
     * Сравнение нескольких продуктов и вывод рейтинга
     */
    public static void rankProducts(Product[] products) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("           РЕЙТИНГ ПРОДУКТОВ (по цене)");
        System.out.println("=".repeat(70));


        Product[] sorted = products.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].getFinalPrice() > sorted[j].getFinalPrice()) {
                    Product temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }

        for (int i = 0; i < sorted.length; i++) {
            System.out.print((i + 1) + ". " + sorted[i].getTitle());
            System.out.println(" - $" + sorted[i].getFinalPrice());
        }

        System.out.println("\nСамый дешёвый: " + sorted[0].getTitle());
        System.out.println("Самый дорогой: " + sorted[sorted.length - 1].getTitle());
        System.out.println("=".repeat(70));
    }
}



