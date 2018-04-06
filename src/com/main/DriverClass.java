package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.constants.Category;
import com.invoice.exception.InvoiceException;
import com.model.FlatTax;
import com.model.PercentageTax;
import com.model.PurchasableItem;
import com.model.Receipt;
import com.model.TaxingEntity;
import com.service.BillingService;
import com.service.ReceiptGenerator;
import com.service.TaxRules;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Category,Set<TaxingEntity>> taxMap = new HashMap<Category, Set<TaxingEntity>>();
		Map<Category,Set<TaxingEntity>> taxExemptedMap = new HashMap<Category, Set<TaxingEntity>>();
		TaxingEntity gst = new PercentageTax("GST",17.5);
		TaxingEntity cdTax = new FlatTax("CDTax", 1.25);
		Set<TaxingEntity> taxSet1 = new HashSet<TaxingEntity>();
		Set<TaxingEntity> taxSet2 = new HashSet<TaxingEntity>();
		Set<TaxingEntity> taxSet3 = new HashSet<TaxingEntity>();
		taxSet1.add(gst);
		taxSet2.add(cdTax);
		taxSet3.add(gst);
		taxMap.put(Category.ALL, taxSet1);
		taxMap.put(Category.CD, taxSet2);
		taxExemptedMap.put(Category.MEDICINE, taxSet3);
		TaxRules.addRules(taxMap, taxExemptedMap);
		
		PurchasableItem i1 = new PurchasableItem(20D, Category.MEDICINE, 2D);
		i1.setName("Aspirin");
		PurchasableItem i2 = new PurchasableItem(20D, Category.OTHERS, 1D);
		i2.setName("Box");
		List<PurchasableItem> itemList = new ArrayList<PurchasableItem>();
		itemList.add(i1);
		itemList.add(i2);
		try {
			Receipt receipt = ReceiptGenerator.generateReceipt(itemList);
			ReceiptGenerator.printReceipt(receipt);
		} catch (InvoiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
