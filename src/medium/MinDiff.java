package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://www.geeksforgeeks.org/tug-of-war/
 * */
public class MinDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,4,5,-3,100,1,89,54,23,20};
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			l.add(a[i]);
		}
		System.out.println(splitArray(l));
	}
	
	static int splitArray(List<Integer> arr) {
        int set1[] = new int[(1+arr.size())/2];
        int set2[] = new int[(1+arr.size())/2];
        int[] a = new int[arr.size()];
        for(int i=0;i<arr.size();i++) {
        		a[i] = arr.get(i);
        }
        divideInEqualSums (a, set1, set2);
//        System.out.println(set1);
//        System.out.println(set2);
        int sum1 = 0,sum2=0;
        for(int i=0;i<set1.length;i++) {
        		sum1+= set1[i];
        }
        for(int i=0;i<set2.length;i++) {
    			sum2+= set2[i];
        }
        return Math.abs(sum1-sum2);
    }
    
    private static void divideInEqualSums(int[] arr, int[] set1, int[] set2) 
    {
        int sSize = set1.length;
        Arrays.sort(arr);
        int p1=0,p2=0,i=arr.length-1,sum1=0,sum2=0;        
        while (p1<sSize && p2<sSize)
        {
            if (sum1<sum2) {
                set1[p1] = arr[i];
                p1++;
                sum1 += arr[i];
            } else {
                set2[p2] = arr[i];
                p2++;
                sum2 += arr[i];
            }
            i--;
        }
        
        while(i>=0) {
            if (p1 < sSize)
                set1[p1++] = arr[i];
            else
                set2[p2++] = arr[i];
            i--;
        }
        
//        print(arr);
//        print(set1);
//        print(set2);
    }
    
//    static void print (int arr[])
//    {
//        int sum1 = 0;
//        for (int i=0; i<arr.length; i++)
//        {
//            sum1 += arr[i];
//            System.out.print(arr[i]+",");
//        }
//        System.out.println(" = " + sum1);
//    }

}
