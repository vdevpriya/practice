package com.model;

import com.constants.TaxType;

public abstract class Tax extends TaxingEntity{
	protected TaxType taxType; 
	
	public abstract void applyTax(PurchasableItem item);
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}

	public TaxType getTaxType() {
		return taxType;
	}

	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}
	
	
}
