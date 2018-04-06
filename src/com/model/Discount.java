package com.model;

import com.constants.DiscountType;

public abstract class Discount extends TaxingEntity{
	protected DiscountType discountType;
	
	public abstract void applyDiscount(PurchasableItem item);

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

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	
}
