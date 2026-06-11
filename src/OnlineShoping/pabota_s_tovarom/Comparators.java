package OnlineShoping.pabota_s_tovarom;



import OnlineShoping.Product.Product;
import OnlineShoping.Tovary.GardenItem;
import OnlineShoping.Tovary.Laptop;

import java.util.Comparator;

public class Comparators {
    public static Comparator<Product> byPriceDesc() {
        return (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice());
    }

    public static Comparator<Product> byTitle() {
        return (p1, p2) -> p1.getTitle().compareTo(p2.getTitle());
    }

    public static Comparator<Product> byRam() {
        return (p1, p2) -> {
            if (p1 instanceof Laptop && p2 instanceof Laptop) {
                return Integer.compare(((Laptop) p1).getRam(), ((Laptop) p2).getRam());
            }
            return 0;
        };
    }

    public static Comparator<Product> bySeason() {
        return (p1, p2) -> {
            if (p1 instanceof GardenItem && p2 instanceof GardenItem) {
                return ((GardenItem) p1).getSeason().compareTo(((GardenItem) p2).getSeason());
            }
            return 0;
        };
    }
}