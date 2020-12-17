package principle;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        Map map = new HashMap();
        child.doSomething(map);
    }
}
