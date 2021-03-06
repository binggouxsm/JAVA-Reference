# Decorator

## 作用

在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式

优点：
- 装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用 
- 通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果
- 完全遵守开闭原则

缺点：装饰模式会增加许多子类，过度使用会增加程序得复杂性

![Decorator 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Decorator.png)



### 组合与继承对比：

| 优缺点\方法 | 继承 | 组合 |
|-| - | - |
| 优点 | 1. 创建子类对象无需创建父类对象<br/> 2. 扩展实现简单，只需新建子类方法| 1.不破坏封装，整体类和局部类松耦合<br/> 2. 运行时动态组合<br/> 3.整体类可以对局部类包装形成新的接口；调用新方法不再受到继承中命名等诸多限制; |
| 缺点 | 1. 子类与父类高度耦合，破坏封装；<br/>2. 编译时就确定关系，无法在运行时动态继承 | 1. 新建整体类对象时，需新建局部类对象<br/> 2. 为了能组合多个对象，必须仔细对接口进行定义。|

组合比继承灵活，优先使用组合

## 实现

```java

public interface Decorable {
    public void show();
}

public class Door implements Decorable {
    public void show() {
        System.out.println("Door show up");
    }
}

public class ChristmasTree implements Decorable {
    public void show() {
        System.out.println("Christmas tree show up");
    }
}

public abstract class ChristmasDecorator implements Decorable{
    protected Decorable component;
    public ChristmasDecorator(Decorable component){
        this.component = component;
    }
    public void show() {
        component.show();
    }
}

// 圣诞花环
public class Garland extends ChristmasDecorator {
    public Garland(Decorable component) {
        super(component);
    }
    public void show() {
        this.additionalDecorate();
        super.show();
    }
    private void additionalDecorate(){
        System.out.println("Garland show up");
    }
}

// 彩灯
public class Light extends ChristmasDecorator {
    public Light(Decorable component) {
        super(component);
    }
    public void show() {
        this.additionalDecorate();
        super.show();
    }
    private void additionalDecorate(){
        System.out.println("Light show up");
    }
}
// 彩带
public class Ribbon extends ChristmasDecorator {
    public Ribbon(Decorable component) {
        super(component);
    }
    public void show() {
        this.additionalDecorate();
        super.show();
    }
    private void additionalDecorate(){
        System.out.println("Ribbon show up");
    }
}

public class Main {

    public static void main(String[] args) {
        Decorable door = new Door();
        ChristmasDecorator decoDoor = new Garland(door);
        decoDoor.show();

        Decorable tree = new ChristmasTree();
        ChristmasDecorator decoTree = new Ribbon(new Light(new Garland(tree)));
        decoTree.show();

    }
}
```