package observer.origin;

public class Main {
    public static void main(String[] args) {
        Observer ob1 = new ConcreteObserver1();
        Observer ob2 = new ConcreteObserver2();

        Subject sub = new ConcreteSubject();
        sub.addObserver(ob1);
        sub.addObserver(ob2);

        sub.notifyObserver();
    }
}
