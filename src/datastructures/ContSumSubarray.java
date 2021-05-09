package datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*package whatever //do not write package name here */

class ContSumSubarray {
	
	void hello () {
		System.out.println("Hi");
	}
	public static void main (String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		for(int i=0;i<t;i++)
//		{
//			String ns= br.readLine();
//			int n = Integer.parseInt(ns.split(" ")[0]);
//			int s = Integer.parseInt(ns.split(" ")[1]);
//			String input = br.readLine();
//			String[] inputarr = input.split(" ");
//			int[] arr = new int[n];
//			for(int j=0;j<n;j++)
//			{
//				arr[j] = Integer.parseInt(inputarr[j]);
//			}                      
//			findContSumSubarray(arr,s);
//		}
		ContSumSubarray1  a= new ContSumSubarray1();
		a.heelo();
	}
	
	private static void findContSumSubarray(int[] arr,int s) {
		// TODO Auto-generated method stub
		int l = 0;
		int r = 0;
		int s1=arr[l];
		while(r<arr.length && l<=r)
		{
			
			if(s1==s)
			{
				System.out.println(l+1+" "+(r+1));
				return;
			}
			else if(s1>s)
			{
				s1=s1-arr[l];
				l=l+1;
			}
			else if(r+1<arr.length)
			{
				r=r+1;
				s1+=arr[r];
			}
			else
			{
				System.out.println("-1");
				return;
			}
		}
	}
}


class ContSumSubarray1 extends ContSumSubarray {
	void heelo() {
		this.hello();
	}
}