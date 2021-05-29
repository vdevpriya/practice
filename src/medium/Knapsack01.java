package medium;

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*Brute Force
	 * O(2^n)
	 * O(1) 
	 */
	private int Knapsack01(int[] weights,int[] values,int WC,int start,int end) {
		if(start>end) {
			return 0;
		}
		if(weights[start]>WC)
			return 0;
		
		return Math.max(Knapsack01(weights,values,WC,start+1,end),
									  Knapsack01(weights,values,WC-values[start],start+1,end)+values[start]);
	}
	
	private int Knapsack01_2(int[] weights,int[] values,int wc) {
		if(weights.length==0)
			return 0;
		
		int[][] dp = new int[weights.length][wc+1];
		
		for(int i=0;i<weights.length;i++) {
			dp[i][0] = 0;
		}
		
		for(int col = 1;col<wc+1;col++) {
			for(int row=0;row<weights.length;row++) {
				if(weights[row]>col) {
					dp[row][col] = row>0?dp[row-1][col]:0;
				}
				dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col-weights[row]]+values[row]);
			}
		}
		return dp[weights.length-1][wc];
	}

}
