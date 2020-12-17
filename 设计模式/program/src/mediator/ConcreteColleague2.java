package mediator;

public class ConcreteColleague2 extends Colleague {

    @Override
    public void send(String msg) {
        System.out.println("ConcreteColleague2 Send msg:" + msg);
        mediator.relay(this,msg);
    }

    @Override
    public void receive(Colleague from, String msg) {
        System.out.println("ConcreteColleague2 receive msg from "+ from.getClass().getName() + ":" + msg);

    }
}
