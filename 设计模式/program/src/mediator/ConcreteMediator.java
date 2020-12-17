package mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator{

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague c) {
        colleagues.add(c);
        c.setMediator(this);
    }

    @Override
    public void unregister(Colleague c) {
        colleagues.remove(c);
        c.setMediator(this);
    }

    @Override
    public void relay(Colleague from, String msg) {
        for (int i = 0; i < colleagues.size(); i++) {
            colleagues.get(i).receive(from,msg);
        }
    }
}
