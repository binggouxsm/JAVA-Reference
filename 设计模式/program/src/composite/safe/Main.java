package composite.safe;

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
