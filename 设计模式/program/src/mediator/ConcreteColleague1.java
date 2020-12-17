package mediator;

public class ConcreteColleague1 extends Colleague {

    @Override
    public void send(String msg) {
        System.out.println("ConcreteColleague1 Send msg:" + msg);
        mediator.relay(this,msg);
    }

    @Override
    public void receive(Colleague from, String msg) {
        System.out.println("ConcreteColleague1 receive msg from "+ from.getClass().getName() + ":" + msg);

    }
}
