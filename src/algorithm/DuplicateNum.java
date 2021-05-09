package algorithm;

import java.util.Arrays;

public class DuplicateNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	 public int findDuplicate(int[] nums) { 
		 Arrays.sort(nums);
		 
		 for(int i =0;i<nums.length-1;i++) {
			 if(nums[i]==nums[i+1]) {
				 return nums[i];
			 }
		 }
		 
		 return -1;
	 }
}
