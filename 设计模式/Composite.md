# Composite

## 作用

树形结构

![Composite 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Composite.png)

## 实现

透明式：

```java
public interface Component {
    public void add(Component c);
    public void remove(Component c);
    public void operation();
}

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    public void add(Component c){
        this.children.add(c);
    }
    public void remove(Component c){
        this.children.remove(c);
    }
    public void operation() {
        for (Component c : children){
            c.operation();
        }
    }
}

public class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        this.name = name;
    }
    // 生成空方法
    public void add(Component c) {
    }
    // 生成空方法
    public void remove(Component c) {
    }
    public void operation() {
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Component root = new Composite();
        Component leaf1 = new Leaf("leaf1");
        Component node2 = new Composite();
        Component leaf21 = new Leaf("leaf21");
        Component leaf22 = new Leaf("leaf22");

        root.add(leaf1);
        root.add(node2);
        node2.add(leaf21);
        node2.add(leaf22);

        root.operation();

    }
}
```

安全式：

```java
public interface Component {
    public void operation();
}
public class Composite implements  Component{
    private List<Component> children = new ArrayList<>();
    public void add(Component c){
        this.children.add(c);
    }
    public void remove(Component c){
        this.children.remove(c);
    }
    public void operation() {
        for (Component c : children){
            c.operation();
        }
    }
}
public class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        this.name = name;
    }
    public void operation() {
        System.out.println(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Composite root = new Composite();
        Leaf leaf1 = new Leaf("leaf1");
        Composite node2 = new Composite();
        Leaf leaf21 = new Leaf("leaf21");
        Leaf leaf22 = new Leaf("leaf22");

        root.add(leaf1);
        root.add(node2);
        node2.add(leaf21);
        node2.add(leaf22);

        root.operation();

    }
}
```


