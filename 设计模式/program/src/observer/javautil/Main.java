package observer.javautil;

public class Main {
    public static void main(String[] args) {
        TargetSubject sub = new TargetSubject();
        sub.addObserver(new ConcreteObserver());

        sub.setPrice(10);
    }
}
