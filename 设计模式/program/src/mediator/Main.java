package mediator;

public class Main {
    public static void main(String[] args) {
        Colleague one = new ConcreteColleague1();
        Colleague two = new ConcreteColleague2();

        Mediator mediator = new ConcreteMediator();
        mediator.register(one);
        mediator.register(two);

        one.send("asdasd");
    }
}
