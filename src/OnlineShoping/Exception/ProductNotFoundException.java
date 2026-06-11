package OnlineShoping.Exception;
/*
*Товар не найден
 */
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super("Товары не найдены" + message);
    }

    public ProductNotFoundException(String productName, long productId){
        super("Товар " + productName + "(ID: " + productId + ") не найден в каталоге");
    }
}
