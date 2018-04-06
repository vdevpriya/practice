package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.constants.Category;
import com.invoice.exception.InvoiceException;
import com.model.FlatTax;
import com.model.PercentageTax;
import com.model.PurchasableItem;
import com.model.Receipt;
import com.model.TaxingEntity;

import junit.framework.Assert;

public class ReceiptGeneratorTest {

	@BeforeClass
	public static void prepTaxRules()
	{		
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
	}
	
	@Test
	public void generateReceipt()
	{
		PurchasableItem i1 = new PurchasableItem(20D, Category.MEDICINE, 2D);
		i1.setName("Aspirin");
		PurchasableItem i2 = new PurchasableItem(20D, Category.OTHERS, 1D);
		i2.setName("Box");
		PurchasableItem i3 = new PurchasableItem(45.5D, Category.OTHERS, 5D);
		i3.setName("Snacks");
		
		List<PurchasableItem> itemList = new ArrayList<PurchasableItem>();
		itemList.add(i1);
		itemList.add(i2);
		itemList.add(i3);
		
		try {
			Receipt r = ReceiptGenerator.generateReceipt(itemList);
			ReceiptGenerator.printReceipt(r);
			Assert.assertNotNull(r);
		} catch (InvoiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
