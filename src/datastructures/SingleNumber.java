package datastructures;

import java.util.HashSet;
import java.util.Set;

// - 6442450365
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
		SingleNumber m = new SingleNumber();
		System.out.println(m.singleNumber(arr));

	}

	 public int singleNumber(int[] nums) {
		 Set uniqueNum = new HashSet<Integer>();
		 long totalSum = 0;
		 long uniqueSum = 0;
		 for (int i=0;i<nums.length; i++) {
			totalSum += nums[i];
			if(!uniqueNum.contains(nums[i])) {
				uniqueNum.add(nums[i]);
				uniqueSum += nums[i];
			}
		}
		 long diff = 3*uniqueSum -  totalSum ;
		 int singleNum = (int)((diff) / 2);
		 return singleNum;
	    }
}
