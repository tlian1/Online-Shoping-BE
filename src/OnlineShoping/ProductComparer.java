package OnlineShoping;

public class ProductComparer {
    public static boolean canCompare(Product p1, Product p2) {
        return p1.getClass().equals(p2.getClass());
    }

    public static void compare(Product p1, Product p2) {
        System.out.println("--- Сравнение ---");
        p1.showInfo();
        p2.showInfo();

        if (p1.getPrice() > p2.getPrice()) System.out.println("» " + p1.getTitle() + " дороже.");
        else if (p2.getPrice() > p1.getPrice()) System.out.println("» " + p2.getTitle() + " дороже.");
        else System.out.println("» Цена одинаковая.");

        if (p1 instanceof Laptop && p2 instanceof Laptop) {
            Laptop l1 = (Laptop) p1;
            Laptop l2 = (Laptop) p2;
            System.out.println("RAM: " + l1.getRam() + "GB vs " + l2.getRam() + "GB");
        }
        if (p1 instanceof Phone && p2 instanceof Phone) {
            Phone ph1 = (Phone) p1;
            Phone ph2 = (Phone) p2;
            System.out.println("Battery: " + ph1.getBattery() + "mAh vs " + ph2.getBattery() + "mAh");
        }
    }
}



