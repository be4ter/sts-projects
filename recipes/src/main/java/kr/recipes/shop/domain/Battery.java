package kr.recipes.shop.domain;

public class Battery extends Product {
	private boolean recheargeable;

	public Battery() {
		super();
	}

	public Battery(String name, double price) {
		super(name, price);
	}

	public void setRechargeable(boolean recheargeable) {
		this.recheargeable = recheargeable;
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}

	public void setName(String name) {
		super.setName(name);
	}
}
