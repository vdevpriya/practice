package com.model;

import com.constants.DiscountType;

public abstract class Discount extends TaxingEntity{
	protected DiscountType discountType;
	
	public abstract void applyDiscount(PurchasableItem item);

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	
}
