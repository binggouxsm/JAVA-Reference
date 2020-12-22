package observer.event;

public class ConcreteSubject extends Subject {

    public void changeState(){
        Event event = new Event(this);
        fireEvent(event);
    }
}
