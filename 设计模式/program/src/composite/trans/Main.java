package composite.trans;

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
