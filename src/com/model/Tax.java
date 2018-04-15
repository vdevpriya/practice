package com.model;

import com.constants.TaxType;

public abstract class Tax extends TaxingEntity{
	protected TaxType taxType; 
	
	public abstract void applyTax(PurchasableItem item);

	public TaxType getTaxType() {
		return taxType;
	}

	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}
	
	
}
