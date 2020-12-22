package observer.event;

public class ConcreteListener1 implements Listener{
    @Override
    public void actionOnEvent(Event e) {
        System.out.println("ConcreteListener1 handler event from " + e.getSource().toString());
    }
}
