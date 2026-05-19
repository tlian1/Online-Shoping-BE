package Pattern;

public class ImmutableClassObject {
    public static void main(String[] args) {
        imutableDemo();
    }

    private static void imutableDemo() {
        System.out.println("\n ========= 5. Immutable Class =========");

        Product product = new Product("Phone", 900);

        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
    }

    final static class Product {
        private final String title;
        private final int price;

        public Product(String title, int price) {
            this.title = title;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public String getTitle() {
            return title;
        }
    }
}
