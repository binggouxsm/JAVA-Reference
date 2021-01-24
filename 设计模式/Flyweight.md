# Flyweight

## 作用

运用共享技术来有效地支持大量细粒度对象的复用。通过共享和复用，减少大量创建对象的开销，提高利用率

优点： 相同的对象保存一份，提高利用率
缺点：不能共享的对象外部化，增加程序复杂度；读取享元模式的外部状态会使得运行时间稍微变长。

内部状态指对象共享出来的信息，存储在享元信息内部，并且不会随环境的改变而改变；
外部状态指对象得以依赖的一个标记，随环境的改变而改变，不可共享。

![Flyweight 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Flyweight.png)

复合享元模式: 将享元模式和复合模式结合，复合享元对象是由单个享元对象组合而成。复合享元对象本身不能共享，但它们可以分解成单纯享元对象再被共享。


## 实现

```java

public class Unshared {
	private String info;
	public Unshared(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}

public interface Flyweight {
	public void operation(Unshared state);
}

public class ConcreteFlyweight implements Flyweight{
	private String key;
	public ConcreteFlyweight(String key) {
		this.key = key;
		System.out.println("具体享元" + key + "被创建！");
	}
	@Override
	public void operation(Unshared state) {
		System.out.print("具体享元" + key + "被调用，");
	      System.out.println("非享元信息是:" + state.getInfo());
	}
}

public class FlyweightFactory {
	
	private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
	
	public Flyweight getFlyweight(String key){
		Flyweight flyweight = (Flyweight) flyweights.get(key);
		if (flyweight != null) {
			System.out.println("具体享元" + key + "已经存在，被成功获取！");
		} else {
			flyweight = new ConcreteFlyweight(key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}
}

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

public class Main {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f01 = factory.getFlyweight("a");
		Flyweight f02 = factory.getFlyweight("a");
		Flyweight f03 = factory.getFlyweight("a");
		Flyweight f11 = factory.getFlyweight("b");
		Flyweight f12 = factory.getFlyweight("b");
		f01.operation(new Unshared("第1次调用a。"));
		f02.operation(new Unshared("第2次调用a。"));
		f03.operation(new Unshared("第3次调用a。"));
		f11.operation(new Unshared("第1次调用b。"));
		f12.operation(new Unshared("第2次调用b。"));
		
		CompositeConcreteFlyweight com = new CompositeConcreteFlyweight();
		com.add(f01);
		com.add(f02);
		CompositeConcreteFlyweight com1 = new CompositeConcreteFlyweight();
		com1.add(f03);
		com1.add(f11);
		com1.add(f12);
		com.add(com1);
		com.operation(new Unshared("第1次调用复合享元"));
	}

}
```