package medium;

import java.util.LinkedList;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 100, 1, 89, 54, 23, 20 };
		//System.out.println(isSubSetSum(arr, 0, arr.length - 1, 26));
		//s1.stream().forEach(System.out::println);
		SubsetSum s = new SubsetSum();
		System.out.println(s.dpSolution(43, arr));
	}

	static List<Integer> s1 = new LinkedList<>();

	public static boolean isSubSetSum(int[] arr, int start, int end, int targetSum) {
		if (targetSum == 0) {
			return true;
		}
		if (end < start) {
			if (targetSum > 0)
				return false;
			else {
				return targetSum == 0;
			}
		}

		boolean a = isSubSetSum(arr, start, end - 1, targetSum);
		if (a) {
			for (int i = start; i <= end; i++) {
				System.out.print(arr[i] + ",");
			}
			System.out.println("----" + targetSum);
		}

		if (!a) {
			a = isSubSetSum(arr, start, end - 1, targetSum - arr[end]);
			if (a) {
				s1.add(arr[end]);
				for (int i = start; i <= end; i++) {
					System.out.print(arr[i] + ",");
				}
				System.out.println("----" + targetSum);
			}
		}
		return a;
	}
	
	//Works for non-negative arr
	boolean dpSolution(int sum,int[] arr) {
		boolean[][] dpArr = new boolean[arr.length][sum+1];
		for(int row=0;row<arr.length;row++) {
			dpArr[row][0] = false;
		}
		
		for(int c=1;c<=sum;c++) {
			for(int r=0;r<arr.length;r++) {
				dpArr[r][c] = fillDPArr(r, c, arr, dpArr);
			}
		}
		
		return dpArr[arr.length-1][sum];
	}
	
	boolean fillDPArr(int row,int col,int[] arr,boolean[][] dpArr) {
		if(row<0 || col<0)
			return false;
		if(arr[row]==col)
			return true;
		if(row<=0 || row>arr.length)
			return false;
		if(col>=dpArr[0].length)
			return false;
		
		return dpArr[row-1][col] || (col-arr[row]>=0 && col-arr[row]<dpArr[0].length && dpArr[row-1][col-arr[row]]);
	}

}
