package com.model;

import com.constants.TaxType;

public class FlatTax extends Tax {
	
	public FlatTax(String name,Double value)
	{
		this.name = name;
		this.value = value;
		this.taxType = TaxType.FLAT;
	}

	@Override
	public void applyTax(PurchasableItem item) {
		// TODO Auto-generated method stub
		item.writeLock.writeLock().lock();
		if(!(null==item || item.getPrice()==null || item.getPrice()==0D))
		{
			//item.setTotlaPrice((item.getTotlaPrice().equals(0D))?(item.getPrice()+this.value)*item.getQuantity():item.getTotlaPrice()+(this.value*item.getQuantity()));
			item.setTotalTaxApplied(item.getTotalTaxApplied()+(this.value*item.getQuantity()));
		}
		item.writeLock.writeLock().unlock();
	}

	@Override
	public void apply(PurchasableItem item) {
		// TODO Auto-generated method stub
		try
		{
			applyTax(item);
		}
		catch(ClassCastException e)
		{
			System.out.println("Item is not purchasable:"+e.getMessage());
		}
	}
	public String toString()
	{
		String str = this.getName()+" "+this.getValue()+" FLAT TAX";
		return str;
	}
}
