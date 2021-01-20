package flyweight;

public class UnsharedConcreteFlyweight {
	
	private String info;
	
	public UnsharedConcreteFlyweight(String info) {
		super();
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
