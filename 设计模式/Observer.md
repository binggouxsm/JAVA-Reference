# Observer

## 作用

当一个对象状态变化时通知所有依赖它的对象，并自动更新状态。该模式又称为发布-订阅模式

![Observer 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Observer.png)

优点：
降低目标与观察者之间的耦合
目标与观察者之间建立一套触发机制

缺点：
目标与观察者之间的依赖关系并没有完全取消


## 实现
```java
public interface Observer {
    public void response();
}
public class ConcreteObserver1 implements Observer {
    public void response() {
        System.out.println("observer1 triggered");
    }
}
public class ConcreteObserver2 implements Observer {
    public void response() {
        System.out.println("observer2 triggered");
    }
}

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

public class ConcreteSubject extends Subject {
}

public class Main {
    public static void main(String[] args) {
        Observer ob1 = new ConcreteObserver1();
        Observer ob2 = new ConcreteObserver2();

        Subject sub = new ConcreteSubject();
        sub.addObserver(ob1);
        sub.addObserver(ob2);

        sub.notifyObserver();
    }
}
```

## 其他变种

### 事件与监听

![EventListener](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Event.png)

```java
public class Event {
    private Object source;
    public Event(){
    }
    public Event(Object source){
        this.source = source;
    }
    public Object getSource() {
        return source;
    }
    public void setSource(Object source) {
        this.source = source;
    }
}

public interface Listener {
    public void actionOnEvent(Event e);
}
public class ConcreteListener1 implements Listener{
    public void actionOnEvent(Event e) {
        System.out.println("ConcreteListener1 handler event from " + e.getSource().toString());
    }
}
public class ConcreteListener2 implements Listener{
    public void actionOnEvent(Event e) {
        System.out.println("ConcreteListener2 handler event from " + e.getSource().toString());
    }
}

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
public class ConcreteSubject extends Subject {
    public void changeState(){
        Event event = new Event(this);
        fireEvent(event);
    }
}
public class Main {
    public static void main(String[] args) {
        ConcreteSubject sub = new ConcreteSubject();
        sub.addListener(new ConcreteListener1());
        sub.addListener(new ConcreteListener2());

        sub.changeState();
    }
}
```

### java.util.Observable 与 java.util.Observer

```java
public class TargetSubject extends Observable {

    public void setPrice(int price){
        // 设置状态发生变化
        this.setChanged();
        // 通知相关的Observer,并传入Object参数
        this.notifyObservers(price);
    }
}

public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object obj) {
        System.out.println(o.hashCode()+" change price to "+obj.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        TargetSubject sub = new TargetSubject();
        sub.addObserver(new ConcreteObserver());
        sub.setPrice(10);
    }
}
```
