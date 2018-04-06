package com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.constants.Category;

public class PercentageDiscountTest {

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
		PercentageDiscount fd = new PercentageDiscount("FlatDiscountTest", 3D);
		fd.applyDiscount(i1);
		fd.apply(i2);
		Assert.assertTrue(i1.getTotlaPrice().equals(38.8D));
		Assert.assertTrue(i2.getTotlaPrice().equals(19.4D));
	}

}
