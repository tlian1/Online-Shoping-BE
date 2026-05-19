package Pattern;

public class SingletonPattern {
    public static void main(String[] args) {
        singletonDemo();

    }
    private static void singletonDemo(){
        System.out.println("\n ======== 3. Singleton Pattern =========");

        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        config1.printConfig();

        System.out.println("config1 == config 2: " + (config1 == config2));
    }

    static class AppConfig {
        private static AppConfig instance;

        private AppConfig() {
        }

        public static AppConfig getInstance() {
            if (instance == null) {
                instance = new AppConfig();
            }

            return instance;
        }

        public void printConfig() {
            System.out.println("Настройки приложения загружены");
        }
    }
}
