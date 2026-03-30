public class Catalog {
    //todo первое поле id
    //todo Второе поле title
    //todo Третье поле price double
    //todo Полная инкомпсюляция
    //todo Создать дда объекта в main и запускаем. Запускаем два объекта
    private int id;
    private String title;
    private double price;

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
}
