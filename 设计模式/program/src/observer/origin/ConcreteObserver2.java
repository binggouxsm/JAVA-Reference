package observer.origin;

public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("observer2 triggered");
    }
}
