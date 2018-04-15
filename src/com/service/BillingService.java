package com.service;

import java.util.List;
import java.util.Set;

import com.invoice.exception.InvoiceException;
import com.model.PurchasableItem;
import com.model.TaxingEntity;

public class BillingService {
	
	
	public static void billItems(List<PurchasableItem> itemList) throws InvoiceException
	{
		if(null==itemList || itemList.isEmpty())
			return;
		Set<TaxingEntity> toApplyTaxes;
		TaxRules.writeLock.writeLock().lock();
		for(PurchasableItem item:itemList)
		{
			toApplyTaxes = TaxRules.getTaxesForCategory(item.getCategory());
			item.writeLock.writeLock().lock();
			if(null==toApplyTaxes || toApplyTaxes.isEmpty())
			{
				item.setTotalPrice(item.getPrice()*item.getQuantity());
				continue;
			}
			PriceCalUtil.applyTax(toApplyTaxes, item);
			item.writeLock.writeLock().unlock();
		}
		TaxRules.writeLock.writeLock().unlock();
		
	}
}
