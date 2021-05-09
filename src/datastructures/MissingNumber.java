package datastructures;
/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MissingNumber {
	public static void main (String[] args) throws IOException {
		//code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			int n = Integer.parseInt(br.readLine());
			int s = 0;
			String input = br.readLine();
			String[] inputarr = input.split(" ");
			for(int j=0;j<n-1;j++)
			{
				s+= Integer.parseInt(inputarr[j]);
			}                       
			System.out.println((n*(n+1)/2)-s);
		}
	}
}