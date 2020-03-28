package hw4;

public class App {
    public static void main(String[] args) {
        Notifier emailNotifier = new CommonNotifier(new BaseEmailNotifier());
        emailNotifier.send("EMAIL");

        Notifier emailAndSms = new SmsNotifier(new BaseEmailNotifier());
        emailAndSms.send("SMS");

        Notifier emailAndSmsAndTelegram = new TelegramNotifier(new SmsNotifier(new BaseEmailNotifier()));
        emailAndSmsAndTelegram.send("TELEGRAM");

    }
}
