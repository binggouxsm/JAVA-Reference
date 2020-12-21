package chainOfResponsibility.origin;

public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequestInternal(StringBuffer sb) {
        sb.append("ConcreteHandler2 processed\n");
    }
}
