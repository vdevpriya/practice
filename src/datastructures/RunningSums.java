package datastructures;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RunningSums {

	 public int findLeastNumOfUniqueInts(int[] arr, int k) {
	        Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
	        
	        for(int i=0;i<arr.length;i++) {
	            if(freqMap.containsKey(arr[i])) {
	                freqMap.put(arr[i],freqMap.get(arr[i])+1);
	            } else {
	                freqMap.put(arr[i],1);
	            }
	        }
	        
	        freqMap = sortMapByValues(freqMap);
	        Map<Integer,Integer> freqMapNew = new HashMap<Integer,Integer>();
	        int i = k;
	        Iterator<Map.Entry<Integer, Integer>> itr = freqMap.entrySet().iterator();
	        int size = freqMap.size();
	        while(i>=0 && itr.hasNext()) {
	        		Map.Entry<Integer, Integer> en = itr.next();
	        		if(en.getValue() <= i) {
	        			i = i-en.getValue();
	        			freqMap.put(en.getKey(),0);
	        			size--;
	        		} else {
	        			freqMap.put(en.getKey(),en.getValue()-i);
	        			i = 0;
	        		}
	        }
	        
	        return size;
	    }
	 
	 	Map<Integer,Integer> sortMapByValues(Map<Integer,Integer> map) {
		  Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		  List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(entrySet);
		  
		  Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue() - o2.getValue();
			}
		});
		  
		  Map<Integer, Integer> newMap = new LinkedHashMap<>();
		  entryList.forEach(entry -> {
			  newMap.put(entry.getKey(), entry.getValue());
		  });
		  
		  
		  return newMap;
	 }

}
