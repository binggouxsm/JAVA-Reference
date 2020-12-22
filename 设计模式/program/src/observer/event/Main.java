package observer.event;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject sub = new ConcreteSubject();
        sub.addListener(new ConcreteListener1());
        sub.addListener(new ConcreteListener2());

        sub.changeState();
    }
}
