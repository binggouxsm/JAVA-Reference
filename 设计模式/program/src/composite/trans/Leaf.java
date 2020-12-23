package composite.trans;

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
