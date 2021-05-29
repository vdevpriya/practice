package medium;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 * */
public class LargestValidSequence {
	
	public static void main(String[] args) {
		LargestValidSequence s = new LargestValidSequence();
		int[] a = s.constructDistancedSequence(60);
		for(int i=0;i<a.length;i++) {
			if(i==0) {
				System.out.print("["+a[i]);
			}
			else if(i==a.length-1) {
				System.out.println(a[i]+"]");
			} else {
				System.out.print(" "+a[i]+" ");
			}
			
		}
	}

	public int[] constructDistancedSequence(int n) {
        
		int[] sol = new int[2*n-1];
		SortedSet<Integer> x = new TreeSet<>(Collections.reverseOrder());
		for(int i=1;i<=n;i++)
			x.add(i);
		place(sol, x);
		return sol;
		
    }
	boolean place(int[] arr,SortedSet<Integer> nums) {
		int idx = getNextIdx(arr);
		if(idx==-1)
			return true;
		SortedSet<Integer> triedNos = new TreeSet<>(Collections.reverseOrder());
		while(!nums.isEmpty()) {
			int y = nums.first();
			nums.remove(y);
			if(fits(arr, idx, y)) {
				arr[idx] = y;
				if(y!=1) {
					arr[idx+y] = y;
				}
				TreeSet<Integer> s = new TreeSet<>(Collections.reverseOrder());
				s.addAll(triedNos);
				s.addAll(nums);
				if(place(arr, s)) {
					return true;
				}
				arr[idx] = 0;
				if(y!=1) {
					arr[idx+y] = 0;
				}
				triedNos.add(y);
			} else {
				triedNos.add(y);
			}
		}
		return false;
	}
	boolean fits(int[] arr,int idx,int x) {
		if(x==1)
			return true;
		if(idx+x<arr.length && arr[idx+x]==0)
			return true;
		
		return false;			
	}
	private int getNextIdx(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0)
				return i;
		}
		return -1;
	}
}
