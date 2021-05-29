package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman t = new IntegerToRoman();
		System.out.println(t.intToRoman(3999));
	}
	
	static final int[] keyNums = {1,5,10,50,100,500,1000};
	static final String[] keyRomans = {"I","V","X","L","C","D","M"};
	static Map<Integer,String> keyNumROmanMap = new HashMap<>();
	static Map<Integer,String> exceptionRomanMap = new HashMap<>();
	static final int[] exceptionNums = {4,9,40,90,400,900};
	static final String[] exceptionROmans = {"IV","IX","XL","XC","CD","CM"};
	
	static {
	       IntStream.range(0, keyNums.length).forEach(i -> {
		    	   keyNumROmanMap.put(keyNums[i], keyRomans[i]);	    	   	
	       });
	       
	       IntStream.range(0, exceptionNums.length).forEach(i -> {
	    	   exceptionRomanMap.put(exceptionNums[i], exceptionROmans[i]);	    	   	
       });
	}
	
	public String intToRoman(int num) {
		int x=num;
		int d = 10;
		int y = (x%d);
		String s = "";
		int prev=0;
		while(y!=x) {
			y = y-prev;
			s = intToRoman2(y) + s;
			prev = x%d;
			d=d*10;
			y = (x%d);
		}
		
		if(y<10) {
			return intToRoman2(y);
		} else {
			d = d/10;
			s = intToRoman2((x/d)*(d)) + s;
			return s;
		}
		
	}
	
	public String intToRoman2(int num) {
		if(num==0) {
			return "";
		}
		if(exceptionRomanMap.keySet().contains(num)) {
			return exceptionRomanMap.get(num);
		}
		
		int div = getBasenNum(num);
		String divString = getBaseRoman(div);
		
		StringBuilder roman = new StringBuilder();
		if(num%div==0) {
			IntStream.range(0, num/div).forEach(i -> {
				roman.append(divString);
			});
			return roman.toString();
		} else {
			String s = divString;
			String y = intToRoman(num%div);
			return s+y;
		}
    }
	
	int getBasenNum(int num) {
		if(keyNumROmanMap.containsKey(num)) {
			return num;
		}
		if(num>=1 && num<5)
			return 1;
		if(num>5 && num<10)
			return 5;
		if(num>10 && num<50)
			return 10;
		if(num>50 && num<100)
			return 50;
		if(num>100 && num<500)
			return 100;
		if(num>500 && num<1000)
			return 500;
		if(num>1000)
			return 1000;
		
		return -1;
	}
	
	String getBaseRoman(int num) {
		return keyNumROmanMap.get(num);
	}

}
