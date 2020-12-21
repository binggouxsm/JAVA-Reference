package chainOfResponsibility.origin;

public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequestInternal(StringBuffer sb) {
        sb.append("ConcreteHandler1 processed\n");
    }
}
