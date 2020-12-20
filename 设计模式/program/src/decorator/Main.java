package decorator;

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
