package decorator;

public abstract class ChristmasDecorator implements Decorable{

    protected Decorable component;

    public ChristmasDecorator(Decorable component){
        this.component = component;
    }

    public void show() {
        component.show();
    }
}
