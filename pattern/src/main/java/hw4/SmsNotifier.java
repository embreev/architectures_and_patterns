package hw4;

public class SmsNotifier extends CommonNotifier {
    public SmsNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Send ... " + msg);
    }
}
