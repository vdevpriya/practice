package medium;

public class KadanesAlgo {
	
	/*
	 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
	 * */
	public int maxSubArraySum(int a[]) {
		int maxSoFar = a[0];
		int curr_max = a[0];
		for(int i=1;i<a.length;i++) {
			curr_max = Math.max(a[i], a[i]+curr_max);
			maxSoFar = Math.max(curr_max, maxSoFar);
		}
		return maxSoFar;
	}

}
