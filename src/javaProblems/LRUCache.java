package javaProblems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
	LinkedList<Integer> pq = new LinkedList<>();
	Map<Integer,Integer> cacheMap;
	int capacity = 10;
	
	public LRUCache(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		cacheMap = new LinkedHashMap<>(capacity);
	}
	
	void add(Integer key,Integer value) {
		if(cacheMap.containsKey(key)) {
			pq.remove(key);
			pq.add(key);
			cacheMap.remove(key);
			cacheMap.put(key, value);
		} else {
			if(cacheMap.size()==this.capacity) {
				Integer lrKey = pq.remove();
				cacheMap.remove(lrKey);
			}
			pq.add(key);
			cacheMap.put(key, value);
		}
	}
	Integer get(Integer key) {
		if(cacheMap.containsKey(key)) {
			pq.remove(key);
			pq.add(key);
			return cacheMap.get(key);
		}
		return -1;
	}
	
	void printCache() {
		cacheMap.keySet().forEach(key -> {
			System.out.println(key + "=>"+ cacheMap.get(key));
		});
		System.out.println("");
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.add(1, 10);
		cache.add(2, 20);
		cache.get(2);
		cache.add(3, 12);
		cache.add(4, 13);
		cache.printCache();
		
		cache.get(3);
		cache.get(2);
		cache.add(5, 15);
		cache.printCache();
		
	}

}
