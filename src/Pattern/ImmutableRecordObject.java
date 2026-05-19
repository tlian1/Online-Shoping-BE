package Pattern;

public class ImmutableRecordObject {
    public static void main(String[] args) {
        imutableRecordObject();
    }

    private static void imutableRecordObject(){
        System.out.println("\n ========= 6. Immutable Record ========");
        ProductRecord product = new ProductRecord("Laptop", 1500);

        System.out.println(product.title());
        System.out.println(product.price());
        System.out.println(product);
    }

    record ProductRecord(String title, int price){
        
    }
}
