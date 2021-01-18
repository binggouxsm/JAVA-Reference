package proxy.staticproxy;

public class Main {
	public static void main(String[] args) {
		Subject proxy = new TimeProxy(new LogProxy(new RealSubject()));
		proxy.request();
	}
}
