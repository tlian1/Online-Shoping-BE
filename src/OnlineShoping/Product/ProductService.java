package OnlineShoping.Product;

import OnlineShoping.Exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    /**
     * Поиск товара с обработкой исключений
     */
    public static Product findProductByName(List<Product> products, String name)
            throws ProductNotFoundException {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(" Название для поиска не может быть пустым!");
        }

        System.out.println(" Поиск товара: '" + name + "'...");

        Optional<Product> result = products.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        if (result.isPresent()) {
            System.out.println(" Товар найден:");
            result.get().showInfo();
            return result.get();
        } else {
            throw new ProductNotFoundException(name, 0);
        }
    }

    /**
     * Фильтрация по цене с валидацией
     */
    public static List<Product> filterByPriceRange(List<Product> products, double minPrice, double maxPrice)
            throws IllegalArgumentException {

        if (minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException(" Цена не может быть отрицательной!");
        }

        if (minPrice > maxPrice) {
            throw new IllegalArgumentException(" Минимальная цена не может быть больше максимальной!");
        }

        System.out.println(" Фильтрация товаров от $" + minPrice + " до $" + maxPrice + "...");

        List<Product> filtered = products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("️ Товаров в этом диапазоне не найдено.");
        } else {
            System.out.println(" Найдено " + filtered.size() + " товаров:");
            filtered.forEach(Product::showInfo);
        }

        return filtered;
    }

    public static Product findMostExpensive(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("️ Список товаров пуст!");
            return null;
        }

        return products.stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .orElse(null);
    }
}
