package OnlineShoping;

public class GardenItem extends Category {

    private String season;

    public GardenItem(String title, String description){
        this.season = "Весна-Лето";
    }

    public GardenItem(String title, String descripnion, String season){
    }
    @Override
    public void ShowInfo() {
        System.out.println("САДОВЫЙ ТОВАР");
        System.out.println("ID" + getId());
        System.out.println("Название" + getTitle());
        System.out.println("Описание" + getdescription());
        System.out.println("Сезон" + season);
        System.out.println("Тип" + getType());
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public void SnowInfo() {

    }


    public String getSeason() {
        return season;
    }

}
