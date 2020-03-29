package hw5;

public class Operator extends Handler {
    private String name;

    public Operator(String name) {
        this.name = name;
    }

    @Override
    public void handle(Ring ring) {
        if(isBusy()) {
            System.out.printf("Оператор %s занят\n", name);
            super.handle(ring);
        }
        else {
            System.out.printf("Оператор %s обрабатывает Ring %s\n",
                    name, ring.getData());
        }
    }

    private boolean isBusy() {
        return Math.random() < probability;
    }

    private final double probability = 0.9;

}

