package pe.com.techniser.microservices.limitsservice.bean;

public class Limits {

	private double minimun;
	private double maximum;

	public Limits() {
		super();// TODO Auto-generated constructor stub
	}

	public Limits(double minimunl, double maximum) {
		super();
		this.minimun = minimunl;
		this.maximum = maximum;
	}

	public double getMinimunl() {
		return minimun;
	}

	public void setMinimunl(double minimunl) {
		this.minimun = minimunl;
	}

	public double getMaximum() {
		return maximum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

}
