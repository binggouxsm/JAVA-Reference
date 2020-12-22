package observer.javautil;

import java.util.Observable;

public class TargetSubject extends Observable {

    public void setPrice(int price){
        this.setChanged();
        this.notifyObservers(price);
    }
}
