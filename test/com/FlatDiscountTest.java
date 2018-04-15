package com.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.constants.Category;

public class FlatDiscountTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
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
		FlatDiscount fd = new FlatDiscount("FlatDiscountTest", 3D);
		fd.applyDiscount(i1);
		fd.apply(i2);
		Assert.assertTrue(i1.getTotlaPrice().equals(34D));
		Assert.assertTrue(i2.getTotlaPrice().equals(17D));
	}

}
