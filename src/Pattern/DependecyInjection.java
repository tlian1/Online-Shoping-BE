package Pattern;


public class DependecyInjection {
    public static void main(String[] args) {
        dependencyInjectionDemo();
    }
    private static void dependencyInjectionDemo(){
        System.out.println("\n ======== 4. Dependency Injection ========");

        MessageSender emailSender = new EmailSender();
        NotificationService emailNotification = new NotificationService(emailSender);
        emailNotification.notifyUser("Ваш заказ готов");

    }

    interface MessageSender {
        void send(String message);
    }

    static class EmailSender implements MessageSender {
        public void send(String message) {
            System.out.println("Email: " + message);
        }
    }

    static class TelegramSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("Telegram: " + message);
        }
    }

    static class NotificationService {
        private MessageSender sender;

        public NotificationService(MessageSender sender) {
            this.sender = sender;
        }

        public void notifyUser(String message) {
            sender.send(message);
        }
    }
}
