package hard;

import medium.KadanesAlgo;

public class Maximum_sum_submatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxSubmatrixSum(int[][] matrix) {
		KadanesAlgo kadaneAlgo = new KadanesAlgo();
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] preSum = new int[m][n];
		int maxSumSoFar = -1000000000;
		for(int i =0;i<m;i++) {
			preSum[i][0] = matrix[i][0];
		}
		for(int i=0;i<m;i++) {
			for(int j=1;j<n;j++) {
				preSum[i][j] = preSum[i][j-1]+matrix[i][j];
			}
		}
		
		for(int col1=0;col1<n;col1++) {
			for(int col2=col1;col2<n;col2++) {
				int[] temp = new int[m];
				for(int r=0;r<m;r++) {
					temp[r] = getRowSum(r,col1,col2,preSum,matrix);
				}
				int max = kadaneAlgo.maxSubArraySum(temp);
				if(max>maxSumSoFar) {
					maxSumSoFar = max;
				}
			}
		}
		return maxSumSoFar;
	}
	
	int getRowSum(int r,int c1,int c2,int[][] preSum,int[][] matrix) {
		return preSum[r][c2]-preSum[r][c1]+matrix[r][c1];
	}
	

}
