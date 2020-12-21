package chainOfResponsibility.origin;

public class Main {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        StringBuffer sb = new StringBuffer();
        handler1.handleRequest(sb);

        System.out.println(sb.toString());
    }
}
