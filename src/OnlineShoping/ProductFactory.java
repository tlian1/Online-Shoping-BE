package OnlineShoping;

import java.util.Map;
import java.util.Objects;

public class ProductFactory {
    public static Product createProduct(String type, String title, double price,
                                        String description, Map<String, Object> params){
        switch (type.toLowerCase()){
            case "phone":
                return new Phone(title, price, description,
                        (String) params.get("brand"), (int) params.get("battery"));
            case "laptop":
                return new Laptop(title, price, description,
                        (int) params.get("ram"), (String) params.get("processor"));
            case "garden":
                return new GardenItem(title, price, description,
                        (String) params.get("season"));
            default:
                throw new IllegalArgumentException("Неизвестный тип товара: " + type);
        }
    }
}
