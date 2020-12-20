package decorator;
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
