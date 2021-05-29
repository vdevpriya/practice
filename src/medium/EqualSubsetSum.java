package medium;

import java.util.Arrays;

/**
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
 * */

public class EqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,6};
		System.out.println(EqualSubsetSum.canPartition(a));

	}

	 static boolean canPartition(int[] num) {
		    //TODO: Write - Your - Code
		int sum = Arrays.stream(num).sum();
		if(sum%2!=0)
			return false;
		int s = (int) Math.ceil(sum/2);
		boolean[][] dp = new boolean[num.length][s+1];
		
		for(int i=0;i<num.length;i++) {
			dp[i][0] = false;
		}
		for(int r=0;r<num.length;r++) {
			for(int c=1;c<=s;c++) {
				dp[r][c] = fillDP(r,c,dp,num);
			}
		}
	    return dp[num.length-1][s];
	  }

	private static boolean fillDP(int r, int c,boolean[][] dp,int[] num) {
		// TODO Auto-generated method stub
		if(r<0 || c<0 || r>=dp.length || c>=dp[0].length)
			return false;
		else if(r-1<0)
			return false;
		else if(num[r]==c)
			return true;
		else
			return dp[r-1][c] || (c-num[r]>=0 && dp[r-1][c-num[r]]);
	}
}
