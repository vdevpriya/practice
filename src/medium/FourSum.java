package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	
	public static void main(String[] args) {
		FourSum f = new FourSum();
		//int[] nums = {1,-2,-5,-4,-3,3,3,5};
		int[] nums = {1,0,-1,0,2,-2};
		System.out.println(f.fourSum(nums, 0));
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		quadruple = new HashSet<List<Integer>>();
        boolean found = find(nums.length, 0, target, 4, new ArrayList<Integer>(), nums);
        return new ArrayList<>(quadruple);
    }
	
	Set<List<Integer>> quadruple;
	
	boolean find(int n,int index,int sum,int noOfDigits,List<Integer> list,int[] nums) {
		if(noOfDigits==0) {
			return sum==0;
		}
		if(index>=n) {
			return false;
		}
//		if(nums[index]>sum) {
//			return false;
//		}
		boolean found = false;
		for(int i=index;i<=(n-noOfDigits);i++) {
			list.add(nums[i]);
			if(find(n,i+1,sum-nums[i],noOfDigits-1,list,nums)) {
				found=true;
				if(noOfDigits==1) {
					System.out.println(list);
					quadruple.add(new ArrayList<>(list));
				}
			}
			list.remove(list.size()-1);
		}
		return found;
		 
	}

}
