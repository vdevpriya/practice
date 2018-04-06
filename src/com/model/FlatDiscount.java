package com.model;

import com.constants.DiscountType;

public class FlatDiscount extends Discount{

	
	public FlatDiscount(String name, Double value)
	{
		this.name = name;
		this.value = value;
		this.discountType = DiscountType.FLAT;
	}
	@Override
	public void applyDiscount(PurchasableItem item) {
		// TODO Auto-generated method stub
		item.writeLock.writeLock().lock();
		if(!(null==item || item.getPrice()==null || item.getPrice()==0D))
		{			
			Double discountedPrice = item.getPrice()<this.value?0D:item.getPrice()-this.value;
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
		String str = this.getName()+" "+this.getValue()+"FLAT DISCOUNT";
		return str;
	}
}
