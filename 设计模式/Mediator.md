# Mediator

## 作用

将对象之间复杂的网状结构，改成以Mediator为中心的星型结构

Mediator定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。迪米特法则的应用。

![Mediator 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Mediator.png)

优点：
- 类之间各司其职，符合迪米特法则
- 降低对象之间的耦合性，使对象可以复用
- 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。

缺点：同事类越多时，中介者就会越臃肿，变得复杂且难以维护。


## 实现

```java
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String msg);

    public abstract void receive(Colleague from, String msg);
}

public class ConcreteColleague1 extends Colleague {
    public void send(String msg) {
        System.out.println("ConcreteColleague1 Send msg:" + msg);
        mediator.relay(this,msg);
    }
    public void receive(Colleague from, String msg) {
        System.out.println("ConcreteColleague1 receive msg from "+ from.getClass().getName() + ":" + msg);
    }
}

public class ConcreteColleague2 extends Colleague {
    public void send(String msg) {
        System.out.println("ConcreteColleague2 Send msg:" + msg);
        mediator.relay(this,msg);
    }
    public void receive(Colleague from, String msg) {
        System.out.println("ConcreteColleague2 receive msg from "+ from.getClass().getName() + ":" + msg);
    }
}

public abstract class Mediator {
    public abstract void register(Colleague c);

    public abstract void unregister(Colleague c);

    // 转发
    public abstract void relay(Colleague from, String msg);

}

public class ConcreteMediator extends Mediator{

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague c) {
        colleagues.add(c);
        c.setMediator(this);
    }

    @Override
    public void unregister(Colleague c) {
        colleagues.remove(c);
        c.setMediator(this);
    }

    @Override
    public void relay(Colleague from, String msg) {
        for (int i = 0; i < colleagues.size(); i++) {
            colleagues.get(i).receive(from,msg);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Colleague one = new ConcreteColleague1();
        Colleague two = new ConcreteColleague2();
        Mediator mediator = new ConcreteMediator();
        mediator.register(one);
        mediator.register(two);

        one.send("asdasd");
    }
}
```