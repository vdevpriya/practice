package datastructures;

import java.util.Arrays;

public class NonoverlappingTargetSum {

	public static void main(String[] args) {
		NonoverlappingTargetSum o = new NonoverlappingTargetSum();
		int[] arr = { 26, 5, 16, 1, 2, 2, 25, 20, 1, 5, 1, 9, 32, 4, 2, 2, 3, 34, 6, 8, 1, 1, 2, 45, 2, 2, 1, 1, 1, 50,
				1, 1, 32, 6, 7, 6, 1, 37 };
		int t = 52;
		System.out.println(o.minSumOfLengths(arr, t));
	}

	public int minSumOfLengths(int[] arr, int target) {
		int start = 0;
		int len = arr.length;
		
		int[] best = new int[len];
		Arrays.fill(best, Integer.MAX_VALUE);
		int bestSoFar = Integer.MAX_VALUE;
		int currentSum = 0;
		int minSum = Integer.MAX_VALUE;
		
		for(int end =0;end<len;end++) {
			currentSum+=arr[end];
			while(currentSum>target) {
				currentSum-=arr[start++];
			}
			if(currentSum==target) {
				if(start>1 && best[start-1]!=Integer.MAX_VALUE) {
					minSum = Math.min(minSum, best[start-1]+end-start+1);
				}
				bestSoFar = Math.min(bestSoFar, end-start+1);
			}
			best[end] = bestSoFar;
			
		}
		return minSum == Integer.MAX_VALUE ? -1: minSum;
	}

}
