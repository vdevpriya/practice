package datastructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int[][] ex = {{1,4},{0,2},{3,5}};
		int[][] arr = mi.merge(ex);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i][0]+","+arr[i][1]);
		}
	}

	public int[][] merge(int[][] intervals) {
		List<int[]> intList = new LinkedList<int[]>();
		for(int i=0;i<intervals.length;i++) {
			intList.add(intervals[i]);
		}
		
	    Collections.sort(intList, (a,b) -> {
	    	 	return a[0]-b[0];
	    });
	    
	    int len =  intList.size();
	    for(int i=0;i<len-1;i++) {
	    		int[] a1 = intList.get(i);
	    		int[] a2 = intList.get(i+1);
	    		if(a2[0]>=a1[0] && a2[0]<=a1[1]) {
	    			a1[1] = a2[1]>a1[1] ? a2[1] : a1[1];
	    			intList.remove(i+1);
	    			len--;
	    			i--;
	    		}
	    }
	    int[][] a = new int[intList.size()][2] ;
	    for(int i=0;i<intList.size();i++) {
			a[i] = intList.get(i);
		}
	    return a;
	 }
}
