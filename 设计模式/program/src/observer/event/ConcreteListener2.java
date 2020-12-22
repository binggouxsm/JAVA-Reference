package observer.event;

public class ConcreteListener2 implements Listener{
    @Override
    public void actionOnEvent(Event e) {
        System.out.println("ConcreteListener2 handler event from " + e.getSource().toString());
    }
}
