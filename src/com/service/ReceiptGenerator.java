package com.service;

import java.util.List;

import com.invoice.exception.InvoiceException;
import com.model.Item;
import com.model.PurchasableItem;
import com.model.Receipt;

public class ReceiptGenerator {
	
	
	public static Receipt generateReceipt(List<PurchasableItem> itemsPurchased) throws InvoiceException
	{
		BillingService.billItems(itemsPurchased);
		Double totalAmount = 0D;
		Double totalTaxes = 0D;
		for(PurchasableItem item:itemsPurchased)
		{
			try
			{
				totalAmount+= item.getTotlaPrice();
				totalTaxes+= item.getTotalTaxApplied();
			}
			catch(ClassCastException e)
			{
				System.out.println("Error while genertaing receipt, item not purchasable:"+item);
			}
		}
		Receipt r = new Receipt();
		r.setItemsPurchased(itemsPurchased);
		r.setTotalAmount(totalAmount);
		r.setTotalTaxApplied(totalTaxes);
		return r;
	}
	
	public static Receipt printReceipt(Receipt receipt)
	{
		System.out.println(receipt);
		return receipt;
	}
}
