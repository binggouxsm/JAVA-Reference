package composite.safe;

public class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void operation() {
        System.out.println(name);
    }
}
