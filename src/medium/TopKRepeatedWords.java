package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKRepeatedWords {
	
	String[] topkrepeatedWords(String[] para,int k) {
		Map<String,Integer> inHeapMap = new HashMap<>();
		Map<String,Integer> notInHeapMap = new HashMap<>();
		PriorityQueue<String> heap = new PriorityQueue<String>(k,(s1,s2) -> Integer.compare(inHeapMap.get(s1), inHeapMap.get(s2)));
		Arrays.stream(para).forEach(word -> {
			if(inHeapMap.containsKey(word)) {
				inHeapMap.put(word, inHeapMap.get(word)+1);
				heap.remove(word);
				heap.add(word);
			} else if(notInHeapMap.containsKey(word)) {
				String minRepeatedWord = heap.peek();
				if(inHeapMap.get(minRepeatedWord)<notInHeapMap.get(word)+1) {
					notInHeapMap.put(minRepeatedWord, inHeapMap.get(minRepeatedWord));
					inHeapMap.remove(minRepeatedWord);
					heap.poll();
					heap.add(word);
				} else {
					notInHeapMap.put(word, notInHeapMap.get(word)+1);
				}
			} else {
				if(heap.size()<k) {
					inHeapMap.put(word, 1);
					heap.add(word);
				} else {
					notInHeapMap.put(word, 1);
				}
			}
		});
		return (String[])heap.toArray();
	}
	
}
