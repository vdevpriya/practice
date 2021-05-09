package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class arrWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int targetsum = s.nextInt();
		ArrayList<Integer> l = new ArrayList<Integer>();
		int n = s.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(i<n)
		{
			arr[i]=s.nextInt();
			i++;
		}
		int start=0;
		int end = 0;
		int sum = arr[start];
		while(start<=end || end<=arr.length)
		{
			if(sum==targetsum)
				break;
			else if(sum<targetsum)
			{
				end++;
				sum+=arr[end];
			}
			else
			{
				sum-=arr[start];
				start++;
			}
		}
		if(sum==targetsum)
		{
			System.out.println("start/end:"+start+"/"+end);
		}
		else
		{
			System.out.println("N/A");
		}
	}

}
