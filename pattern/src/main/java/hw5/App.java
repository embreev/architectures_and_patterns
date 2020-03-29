package hw5;

public class App {
    public static void main(String[] args) {
        Handler handler = new BusyHandler();

        handler.link(new Operator("Ivanov"))
                .link(new Operator("Petrov"))
                .link(new Operator("Sidorov"))
                .link(handler);

        for (int i = 0;i<10;i++) {
            final int temp = i;
            handler.handle(new Ring() {
                @Override
                public String getData() {
                    return Integer.toString(temp);
                }
            });
        }

    }
}
