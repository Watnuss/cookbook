package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Equipment {
	private int ID;
	private String name;
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return name;
	}

}
