package flyweight;

public class Main {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f01 = factory.getFlyweight("a");
		Flyweight f02 = factory.getFlyweight("a");
		Flyweight f03 = factory.getFlyweight("a");
		Flyweight f11 = factory.getFlyweight("b");
		Flyweight f12 = factory.getFlyweight("b");
		f01.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
		f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
		f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
		f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
		f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));
		
		CompositeConcreteFlyweight com = new CompositeConcreteFlyweight();
		com.add(f01);
		com.add(f02);
		CompositeConcreteFlyweight com1 = new CompositeConcreteFlyweight();
		com1.add(f03);
		com1.add(f11);
		com1.add(f12);
		com.add(com1);
		com.operation(new UnsharedConcreteFlyweight("第1次调用复合享元"));
	}

}
