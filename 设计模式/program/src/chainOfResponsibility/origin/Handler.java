package chainOfResponsibility.origin;

public abstract class Handler {

    protected Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handleRequest(StringBuffer sb){
        handleRequestInternal(sb);
        if(next != null){
            next.handleRequest(sb);
        }
    }

    public abstract void handleRequestInternal(StringBuffer sb);
}
