package hw5;

public abstract class Handler {
    private Handler next;

    public void handle(Ring ring) {
        if(next != null)
            next.handle(ring);
    }

    Handler link(Handler next) {
        this.next = next;
        return next;
    }
}

