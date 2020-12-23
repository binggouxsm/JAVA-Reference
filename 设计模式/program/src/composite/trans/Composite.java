package composite.trans;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    public void add(Component c){
        this.children.add(c);
    }

    public void remove(Component c){
        this.children.remove(c);
    }

    public void operation() {
        for (Component c : children){
            c.operation();
        }
    }
}
