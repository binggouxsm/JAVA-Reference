package flyweight;

import java.util.ArrayList;
import java.util.List;

public class CompositeConcreteFlyweight implements Flyweight {
	
	private List<Flyweight> children = new ArrayList<Flyweight>();
	
	public void add(Flyweight flyweight) {
		children.add(flyweight);
	}
	
	public void remove(Flyweight flyweight) {
		children.remove(flyweight);
	}

	@Override
	public void operation(Unshared state) {
		for(int i = 0 ; i < children.size(); i++){
			children.get(i).operation(state);
		}
		System.out.println("非享元信息是:" + state.getInfo());
	}
}
