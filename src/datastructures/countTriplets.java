package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class countTriplets {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ii = 0;
		int[] arr = new int[n];
		Map<Integer,Integer> m = new HashMap<>();
		while(ii<n){
			arr[ii] = s.nextInt();
			m.put(ii, ii);
			ii++;
		}
		for(int i = 0;i<arr.length-1;i++){
			for (int j = i+1;j<arr.length;j++){
				if(m.get(arr[i]+arr[j])!=null)
					System.out.println(arr[i]+","+arr[j]+","+(m.get(arr[i]+arr[j])));
			}
		}
	}
}
