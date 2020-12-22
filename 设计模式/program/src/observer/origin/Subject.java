package observer.origin;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObserver(){
        for (Observer observer: observers){
            observer.response();
        }
    }
}
