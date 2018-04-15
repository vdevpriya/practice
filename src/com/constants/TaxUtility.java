package com.constants;

public class TaxUtility {
	
	public static Double roundOff(Double value)
	{
		
		return roundOffToUp05(value);
		
	}
	
	public static Double roundOffToUp05(Double value)
	{
		
		value = (double) (Math.ceil(value*20)/20);
		return value;
		
	}
	public static Double round2DecimalPlaces(Double value)
	{
		
		value = (double) (Math.round(value*100)/100);
		return value;
		
	}
}
