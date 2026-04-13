import java.lang.reflect.Array;
import java.util.ArrayList;

public class Catalog {
    /*
    //todo первое поле id
    //todo Второе поле title
    //todo Третье поле price double
    //todo Полная инкомпсюляция
    //todo Создать дда объекта в main и запускаем. Запускаем два объекта
    //todo этап 2 класс продукт должено быть поле description продукт класс должен быть абстрактным
    //todo клас категория Category id title description
    //todo id автогенерация новые наследники electronic and GardenItem еще класс MobileDivace создаем новый объект из но
    //todo вых классов в категории толжен быть ArrayList сохраняет в себе список категорий два методап addCategory showCategory
    //todo добавить счетчик сколько категорий есть второй сколько subCategory
    */


    private int id;
    private String title;
    private double price;

    private ArrayList<Category> categorys = new ArrayList<>();

    public Catalog() {}

    public Catalog(int id, String title, double price){
        this.id = id;
        this.title = title;
        this.price = price;

    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addCategory(Category category){
        categorys.add(category);
    }

    public  int allCategorys() {
        int c = 0;
        for (Category cat : categorys){
            c += 1 + subCategory(cat);
        }
        return c;
    }

    public int subCategory(){
        int c = 0;
        for (Category cat : categorys){
            c += subCategory(cat);
        }
        return c;
    }

    private int subCategory(Category category) {
        int c = 0;

        return 0;
    }



}
