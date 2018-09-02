package kr.recipes.shop.domain;

public class Disc extends Product {
	private int capacity;
	private double specialEndofyearDiscountField;

	public Disc() {
		super();
	}

	public Disc(String name, double price) {
		super(name, price);
	}

	public Disc(String name, double price, double specialEndofyearDiscountField) {
		super(name, price);
		this.specialEndofyearDiscountField = specialEndofyearDiscountField;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
