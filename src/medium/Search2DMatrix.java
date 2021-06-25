package medium;

import java.util.Arrays;

/**https://leetcode.com/problems/search-a-2d-matrix/
 * */
public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int r = findRow(target, 0, m-1,matrix,n-1);
        if(r==-1)
            return false;
		int k = Arrays.binarySearch(matrix[r],target);
		return k>=0;
    }
	
	int findRow(int target,int start,int end,int[][] matrix,int c) {
		if(matrix[end][c]<target)
			return -1;
        if(end==start) {
            if(matrix[start][c]>=target) {
                return start;
            }
            return -1;
        }
		if(end==start+1) {
			if(matrix[start][c]>=target)
				return start;
			return end;
		}
		int mid = (start+end)/2;
		if(matrix[mid][c]>=target) {
			return findRow(target, start, mid, matrix, c);
		} else {
			return findRow(target, mid, end, matrix, c);
		}
	}
}
