package datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class largestNumBySwap {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largestNumBySwap o = new largestNumBySwap();
		Integer[] arr = {1,2,3,4,5};
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		System.out.println(o.largestNumBySwap(list, 3, 0, arr.length-1));
	}
	
	public int largestNumBySwap(List<Integer> arrList,int k,int start,int end) {
		while(k>0 && start<end) {
			int minSwap = Math.min(k, end-start);
			int maxIdx = findMaxIndex(arrList, start, minSwap);
			System.out.println("maxIdx:"+maxIdx);
			if(arrList.get(maxIdx) != arrList.get(start)) {
				int maxNum = arrList.remove(maxIdx);
				arrList.add(start, maxNum);
				start++;
				k = k - minSwap;
			} else {
				start++;
			}
		}
//		arrList.forEach(i -> {
//			System.out.print(i+' ');
//		});
		int num = 0;
		for(int i=0;i<arrList.size();i++) {
			num = num*(i==0? 1: 10) + arrList.get(i);
		}
		return num;
	}
	public int findMaxIndex(List<Integer> arr, int start, int end) {
		int max = arr.get(start);
		int maxIdx = start;
		for(int i=start;i<=end;i++) {
			if(arr.get(i)>max) {
				max = arr.get(i);
				maxIdx = i;
			}
		}
		return maxIdx;
	}

}
