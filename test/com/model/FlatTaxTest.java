package com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.constants.Category;

public class FlatTaxTest {

	@Test
	public void applyDiscount()
	{
		PurchasableItem i1 = new PurchasableItem(20D, Category.MEDICINE, 2D);
		i1.setName("Aspirin");
		PurchasableItem i2 = new PurchasableItem(20D, Category.OTHERS, 1D);
		i1.setName("Box");
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(i1);
		itemList.add(i2);
		FlatTax fd = new FlatTax("FlatDiscountTest", 3D);
		fd.applyTax(i1);
		fd.apply(i2);
		Assert.assertTrue(i1.getTotalPrice().equals(46D));
		Assert.assertTrue(i2.getTotalPrice().equals(23D));
	}

}
