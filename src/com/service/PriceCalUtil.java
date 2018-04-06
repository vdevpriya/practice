package com.service;

import java.util.Set;

import com.invoice.exception.InvoiceException;
import com.model.PurchasableItem;
import com.model.TaxingEntity;

public class PriceCalUtil {
	
	
	public static void applyTax(TaxingEntity tax,PurchasableItem item) throws InvoiceException
	{
		item.writeLock.writeLock().lock();
		if(null==tax || null==item)
		{
			throw new InvoiceException("Tax/Item is null");
		}
		try
		{
			tax.apply(item);
		}
		catch(ClassCastException e)
		{
			System.out.println("Item is not a purchasable item:"+e.getMessage());
		}
		finally {
			item.writeLock.writeLock().unlock();
		}
		
	}
	public static void applyTax(Set<TaxingEntity> tax,PurchasableItem item) throws InvoiceException
	{
		item.writeLock.writeLock().lock();
		if(null==tax)
		{
			return;
		}
		for(TaxingEntity t:tax)
		{
			applyTax(t, item);
		}
		item.writeLock.writeLock().unlock();
	}	
}
