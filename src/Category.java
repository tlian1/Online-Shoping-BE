import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private int id;
    private String title;
    private String description;

    private static int nextId = 1;
    private List<Category> categorys = new ArrayList<>();

    public Category() {}

    public Category(int id, String title, String description){
        this.id = nextId ++;
        this.title = title;
        this.description = description;


    }


    public abstract void ShowInfo();
    public abstract String getType();

    public int getId() {

        return id;
    }

    public String getdescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void addCategory(Category category){
        categorys.add(category);
    }

    public void showCategory(){
        ShowInfo();
        if (categorys.isEmpty()) {
            System.out.println("Подкатегории");
            for (Category cat : categorys){
                cat.showCategory();
            }
        }
    }




}
