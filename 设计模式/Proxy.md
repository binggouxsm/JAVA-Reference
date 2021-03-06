# Proxy

## 作用

客户端通过代理间接地访问目标对象，从而限制、增强或修改该对象的一些特性。

优点：
1. 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用
2. 代理对象可以扩展目标对象的功能
3. 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性

缺点：
1. 类的数量增加
2. 增加一个代理对象，会造成请求处理速度变慢

![Proxy 模式](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/Proxy.png)

## 实现

```java
public interface Subject {
	public void request();
}

public class RealSubject implements Subject {
	public void request() {
		try {
			Thread.sleep((long) (10000*Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Doing Something");
	}
}

public class LogProxy implements Subject{
	private Subject target;

	public LogProxy(Subject target) {
		this.target = target;
	}
	
	public void request() {
		// Doing something before request 
		System.out.println("Doing something before request");
		target.request();
		// Doing something after request
		System.out.println("Doing something after request");
	}
}

public class TimeProxy implements Subject{
	private Subject target;

	public TimeProxy(Subject target) {
		this.target = target;
	}
	
	public void request() {
		long start = System.currentTimeMillis();
		target.request();
		long end = System.currentTimeMillis();
		System.out.println("Request finish in " + (end -start));
	}
}

public class Main {
	public static void main(String[] args) {
		Subject proxy = new TimeProxy(new LogProxy(new RealSubject()));
		proxy.request();
	}
}

```


代理的设计模式的缺点在于增加类，提高了复杂度，该问题可以通过动态代理得到解决。

