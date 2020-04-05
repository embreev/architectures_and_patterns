package hw4;

public class CommonNotifier implements Notifier{
    private Notifier notifier;

    public CommonNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String msg) {
        System.out.println("Send ... " + (msg.toUpperCase().equals("EMAIL") ? msg: "EMAIL+" + msg));
    }
}
