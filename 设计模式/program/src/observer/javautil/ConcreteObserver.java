package observer.javautil;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object obj) {
        System.out.println(o.hashCode()+" change price to "+obj.toString());
    }
}
