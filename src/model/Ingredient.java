package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Ingredient {

	private int ID;
	private String name;
	private float amount;
	private String unit;
	private Receipt receipt;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@NotEmpty(message = "Name must not be empty")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String toString() {
		return amount + " " + unit + " of " + name;
	}
}
