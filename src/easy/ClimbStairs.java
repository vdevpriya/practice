package easy;

public class ClimbStairs { 
	
	
	
	public int climbStairs(int n) {
		int[] dp = new int[n+1];	
		return climbSt(n, dp);
	}
	public int climbSt(int n,int[] dp) {
		if(n==0 || n==1)
			return 1;
		if(dp[n]!=0) {
			return dp[n];
		}
		int ways = climbSt(n-1,dp) + climbSt(n-2,dp);
		dp[n] = ways;
		return ways;
	}
        

}
