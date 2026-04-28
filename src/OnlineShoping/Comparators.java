package OnlineShoping;



import java.util.Comparator;


public class Comparators {

    /**
     * Сортировка по цене (по возрастанию: от дешевого к дорогому)
     * Использует метод getPrice() из базового класса Product
     */
    public static Comparator<Product> byPriceAscending() {
        return (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
    }

    /**
     * Сортировка по цене (по убыванию: от дорогого к дешевому)
     */
    public static Comparator<Product> byPriceDescending() {
        return (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice());
    }

    /**
     * Сортировка по названию (Алфавит)
     */
    public static Comparator<Product> byTitle() {
        return (p1, p2) -> p1.getTitle().compareToIgnoreCase(p2.getTitle());
    }

    /**
     * Сортировка по Оперативной памяти (RAM)
     * Работает ТОЛЬКО для ноутбуков.
     * Если товары не ноутбуки — они считаются равными (возврат 0).
     */
    public static Comparator<Product> byRam() {
        return (p1, p2) -> {
            // Проверяем, что оба объекта являются Laptop
            if (p1 instanceof Laptop && p2 instanceof Laptop) {
                Laptop l1 = (Laptop) p1;
                Laptop l2 = (Laptop) p2;
                return Integer.compare(l1.getRam(), l2.getRam());
            }
            return 0; // Не сравниваем, если типы не подходят
        };
    }

    /**
     * Сортировка по Сезону использования
     * Работает ТОЛЬКО для садовых товаров (GardenItem).
     */



    /**
     * Сортировка по Бренду
     * Работает ТОЛЬКО для телефонов (Phone).
     */
    public static Comparator<Product> byBrand() {
        return (p1, p2) -> {
            if (p1 instanceof Phone && p2 instanceof Phone) {
                Phone ph1 = (Phone) p1;
                Phone ph2 = (Phone) p2;
                return ph1.getBrand().compareTo(ph2.getBrand());
            }
            return 0;
        };
    }

    public static Comparator<Product> bySeason() {
        return null;
    }
}