package hw5;

public class BusyHandler extends Handler {
    private Ring ring;

    @Override
    public void handle(Ring ring) {
        if(this.ring == ring)
            System.out.println("Все операторы заняты, пожалуйста подождите");
        else
            this.ring = ring;

        super.handle(ring);
    }
}

