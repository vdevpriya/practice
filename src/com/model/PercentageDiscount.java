package com.model;

import com.constants.DiscountType;

public class PercentageDiscount extends Discount{
	
	public PercentageDiscount(String name,Double value) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
		this.discountType = DiscountType.PERCENTAGE;
	}

	@Override
	public void applyDiscount(PurchasableItem item) {
		// TODO Auto-generated method stub
		item.writeLock.writeLock().lock();
		if(!(null==item || item.getPrice()==null || item.getPrice()==0D))
		{
			Double price = item.getPrice();
			Double discountedPrice = price - (this.value*price)/100;
			discountedPrice = discountedPrice<0?0D:discountedPrice;
			Double discountApplied = item.getPrice() - discountedPrice;
			item.setTotalDiscountApplied(item.getTotalDiscountApplied()+discountApplied);
			item.setTotlaPrice(discountedPrice*item.getQuantity());
		}
		item.writeLock.writeLock().unlock();
	}

	@Override
	public void apply(PurchasableItem item) {
		// TODO Auto-generated method stub
		try{
			applyDiscount(item);
		}
		catch(ClassCastException e)
		{
			System.out.println("Item is not purchasable:"+e.getMessage());
		}
	}
	
	public String toString()
	{
		String str = this.getName()+" "+this.getValue()+"% DISCOUNT";
		return str;
	}
	
}
