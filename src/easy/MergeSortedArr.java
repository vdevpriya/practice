package easy;

import java.util.Arrays;

public class MergeSortedArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArr t = new MergeSortedArr();
		int[] b = {1,0,0};
		int[] a = {3,4};
		t.merge(b, 1, a, 2);
		Arrays.stream(b).forEach(System.out::print);
	}
	
	public void merge(int[] b, int m, int[] a, int n) {
		int i1 = m-1;
		int i2 = n-1;
		int ilast = m+n-1;
		int INT_MIN = -1000000000;
		while(ilast>=0) {
			int bEl = i1>=0?b[i1]:INT_MIN;
			int aEl = i2>=0?a[i2]:INT_MIN;
			if(bEl>aEl) {
				b[ilast]=bEl;
				i1--;
			} else {
				b[ilast]=aEl;
				i2--;
			}
			ilast--;
		}
	}

}
