package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
	
	public static void main(String[] args) {
		int[][] intervals = {{3,5},{8,9},{13,16}};
		int[] newInterval = {6,14};
		InsertInterval t = new InsertInterval();
		
//		System.out.println(t.searchInt(intervals, 6, 0, 1));
//		System.out.println(t.searchInt(intervals, 7, 0, 1));
		int[][] newIntervals = t.insert(intervals, newInterval);
		System.out.println("[");
		for(int i=0;i<newIntervals.length;i++) {
			System.out.println("["+newIntervals[i][0] +","+newIntervals[i][1]+"]");
		}
		System.out.print("]");
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		// TODO Auto-generated method stub
		List<int[]> l = new ArrayList<>();
		for(int[] in: intervals) {
			if(in[1]<newInterval[0]) {
				l.add(in);
			} else if (in[0]>newInterval[1]) {
				l.add(newInterval);
				newInterval=in;
			} else {
				newInterval[0]=Math.min(newInterval[0], in[0]);
				newInterval[1]=Math.max(newInterval[1], in[1]);
			}
		}
		l.add(newInterval);
		int[][] res = new int[l.size()][2];
		int i=0;
		for (int[] in : l) {
			res[i++] = in;
		}
		return res;
	}
	
	 

}
