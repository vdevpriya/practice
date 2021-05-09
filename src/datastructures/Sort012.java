package datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int  i=0;i<t;i++)
		{
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] inputarr = input.split(" ");
			int[] arr = new int[n];
			for(int j=0;j<n;j++)
			{
				arr[j] = Integer.parseInt(inputarr[j]);
			}           
			sort012(arr);
		}
	}

	private static void sort012(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		if(len==1)
		{
			System.out.println(arr[0]);
		}
		int start = -1;
		int end = len;
		int tmp;
		int i=0;
		while(i<end)
		{
			if(arr[i]==0 && start<i)
			{
				tmp = arr[start+1];
				arr[start+1] = 0;
				arr[i] = tmp;
				start = start+1;
			}
			else if(arr[i]==2 && end>i)
			{
				tmp = arr[end-1];
				arr[end-1] = 2;
				arr[i] = tmp;
				end = end-1;
			}
			else
			{
				i++;
			}
		}
		for(i=0;i<len;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}

}
