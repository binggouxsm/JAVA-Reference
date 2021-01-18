package proxy.staticproxy;

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
