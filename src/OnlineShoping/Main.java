package OnlineShoping;


import OnlineShoping.pabota_s_tovarom.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = null;

        try {
            System.out.println(" Запуск системы...");
            menu = new Menu();
            menu.start();

        } catch (Exception e) {
            System.err.println(" Критическая ошибка приложения: " + e.getMessage());
            System.err.println("7" + "Детали:");
            e.printStackTrace();
            System.exit(1);

        } finally {
            System.out.println("\n Приложение завершено");
            if (menu == null) {
                System.err.println("️ Меню не было инициализировано");
            }
        }
    }
}
