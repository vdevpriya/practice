package hard;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int knapSack(int W, int[] wt,
            int[] val, int n) {
		if(n==0)
			return -1;
		
		int[][] dp = new int[n+1][W+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=W;j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
				else if(wt[i-1]<=j) {
					dp[i][j] = Math.max(
							val[i-1]+dp[i-1][j-wt[i-1]],
							dp[i-1][j]
							);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][W];
	}

}
