package observer.event;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void fireEvent(Event event){
        for (Listener listener: listeners){
            listener.actionOnEvent(event);
        }
    }

}
