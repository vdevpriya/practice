package com.model;

public abstract class TaxingEntity {
	protected String name;
	protected Double value;
	public abstract void apply(PurchasableItem item);
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
