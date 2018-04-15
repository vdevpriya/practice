package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.constants.Category;
import com.invoice.exception.InvoiceException;
import com.model.FlatDiscount;
import com.model.FlatTax;
import com.model.PercentageDiscount;
import com.model.PercentageTax;
import com.model.PurchasableItem;
import com.model.TaxingEntity;

public class PriceCalUtilTest {

	@Test
	public void applyTaxes()
	{
		PurchasableItem i1 = new PurchasableItem(20D, Category.MEDICINE, 2D);
		i1.setName("Aspirin");
		PurchasableItem i2 = new PurchasableItem(100D, Category.OTHERS, 1D);
		i2.setName("Box");
		List<PurchasableItem> itemList = new ArrayList<PurchasableItem>();
		itemList.add(i1);
		itemList.add(i2);
		FlatTax ft = new FlatTax("FT1", 10D);
		PercentageTax pt = new PercentageTax("PT", 15.3D);
		FlatDiscount fd = new FlatDiscount("FD", 20D);
		PercentageDiscount pd = new PercentageDiscount("PD", 18D);
		Set<TaxingEntity> set = new HashSet<TaxingEntity>();
		set.add(fd);
		set.add(pt);
		try {
			PriceCalUtil.applyTax(pd, i2);
			PriceCalUtil.applyTax(set, i1);
			Assert.assertTrue(i2.getTotalPrice().equals(82D));
			Assert.assertTrue(i1.getTotalPrice().equals(6.15D));
			Assert.assertTrue(i2.getTotalDiscountApplied().equals(18D));
			Assert.assertTrue(i1.getTotalTaxApplied().equals(6.15D));
		} catch (InvoiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


}
