package com.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.constants.Category;
import com.model.FlatTax;
import com.model.PercentageTax;
import com.model.TaxingEntity;

public class TaxRulesTest {

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
	public void addRulesTest() {
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
		System.out.println("Taxes for ALL category items");
		for(TaxingEntity t:TaxRules.getTaxesForCategory(Category.ALL))
		{
			System.out.println(t);
		}
		System.out.println("Taxes for CD category items");
		for(TaxingEntity t:TaxRules.getTaxesForCategory(Category.CD))
		{
			System.out.println(t);
		}
	}

}
