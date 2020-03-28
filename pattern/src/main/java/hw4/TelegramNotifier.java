package hw4;

public class TelegramNotifier extends CommonNotifier {
    public TelegramNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Send ... " + msg);
    }
}
