package com.model;

import com.constants.TaxType;
import com.constants.TaxUtility;

public class PercentageTax extends Tax {

	public PercentageTax(String name,Double value)
	{
		this.name = name;
		this.value = value;
		this.taxType = TaxType.PERCENTAGE;
	}
	
	@Override
	public void applyTax(PurchasableItem item) {
		// TODO Auto-generated method stub
		item.writeLock.writeLock().lock();
		if(!(null==item || item.getPrice()==null || item.getPrice()==0D))
		{
			Double price = item.getPrice();
			Double taxApplied = (this.value*price)/100;
			taxApplied = taxApplied*item.getQuantity();
			taxApplied=TaxUtility.roundOff(taxApplied);
			//Double taxedPrice = price + taxApplied;
			//item.setTotlaPrice(taxedPrice*item.getQuantity());
			//item.setTotlaPrice
			//((item.getTotlaPrice().equals(0D)?(item.getPrice()*item.getQuantity()):item.getTotlaPrice())+(taxApplied*item.getQuantity()));
			item.setTotalTaxApplied(item.getTotalTaxApplied()+taxApplied);
		}
		item.writeLock.writeLock().unlock();
	}

	@Override
	public void apply(PurchasableItem item) {
		// TODO Auto-generated method stub
		try{
			applyTax(item);
		}
		catch(ClassCastException e)
		{
			System.out.println("Item is not purchasable:"+e.getMessage());
		}
	}
	
	public String toString()
	{
		String str = this.getName()+" "+this.getValue()+"% TAX";
		return str;
	}
}
