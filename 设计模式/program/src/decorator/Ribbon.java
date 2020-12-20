package decorator;
// 彩带
public class Ribbon extends ChristmasDecorator {

    public Ribbon(Decorable component) {
        super(component);
    }

    @Override
    public void show() {
        this.additionalDecorate();
        super.show();
    }

    private void additionalDecorate(){
        System.out.println("Ribbon show up");
    }
}
