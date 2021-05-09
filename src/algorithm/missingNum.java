package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.
//
//Output:
//Print the missing number in array.
//
//Constraints:
//1 ≤ T ≤ 200
//1 ≤ N ≤ 107
//1 ≤ C[i] ≤ 107
//
//Example:
//Input:
//2
//5
//1 2 3 5
//10
//1 2 3 4 5 6 7 8 10
//
//Output:
//4
//9
//
//Explanation:
//Testcase 1: Given array : 1 2 3 5. Missing element is 4.

public class missingNum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(bfr.readLine());
		System.out.println(n);
		int ii = 0;
		int[] arr = new int[n];
		int sum = 0 ;
		String[] input  = bfr.readLine().split(" ");
		System.out.println(input);
		while(ii<n){
			arr[ii] =Integer.parseInt(input[ii]);
			System.out.println(arr[ii]);
			sum += arr[ii];
			ii++;
		}
		int m = n+1;
		int sum2 = (m*(m+1))/2;
		System.out.println(sum2-sum);
	}

}
