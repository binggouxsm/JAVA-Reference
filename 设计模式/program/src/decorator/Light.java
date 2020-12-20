package decorator;
// 彩灯
public class Light extends ChristmasDecorator {

    public Light(Decorable component) {
        super(component);
    }

    @Override
    public void show() {
        this.additionalDecorate();
        super.show();
    }

    private void additionalDecorate(){
        System.out.println("Light show up");
    }
}
