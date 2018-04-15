package com.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.constants.Category;
import com.model.TaxingEntity;

public final class TaxRules {
	public static ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
	//taxMap contains taxes specifically applied to a category
	private static final Map<Category,Set<TaxingEntity>> taxMap = new HashMap<Category, Set<TaxingEntity>>();
	//taxExemptedMap contains taxes specifically exempted for a category
	private static final Map<Category,Set<TaxingEntity>> taxExemptedMap = new HashMap<Category, Set<TaxingEntity>>();
	
	public synchronized static void addRules(Map<Category,Set<TaxingEntity>> map,Map<Category,Set<TaxingEntity>> exempted)
	{
		taxMap.putAll(map);
		taxExemptedMap.putAll(exempted);
	}
	
	public static Set<TaxingEntity> getTaxesForCategory(Category cat)
	{
		HashSet<TaxingEntity> toApply = new HashSet<TaxingEntity>();
		HashSet<TaxingEntity> allSet = (HashSet<TaxingEntity>) taxMap.get(Category.ALL);
		toApply.addAll(allSet);
		if(taxMap.containsKey(cat))
		{
			toApply.addAll((HashSet<TaxingEntity>) taxMap.get(cat));
			if(null!=taxExemptedMap.get(cat))
				toApply.removeAll(taxExemptedMap.get(cat));
		}
		else if(taxExemptedMap.containsKey(cat))
		{
			toApply.removeAll(taxExemptedMap.get(cat));
		}
		return toApply;
	}
}
