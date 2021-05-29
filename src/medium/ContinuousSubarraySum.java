package medium;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {1,2,4};
		ContinuousSubarraySum test = new ContinuousSubarraySum();
		System.out.println(test.checkSubarraySum2(n, 6));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums.length<2)
			return false;
        if(k==1)
			return true;
        int [][]  a = new int[nums.length][nums.length];
        for (int i=0;i<nums.length;i++) {
			a[i][i] = nums[i];
		}
        for(int i=0;i<nums.length-1;i++) {
        		for(int j=i+1;j<nums.length;j++) {
        			a[i][j] = a[i][j-1] + a[j][j];
        			if(a[i][j]==0 || a[i][j]%k==0) {
        				return true;
        			}
        		}
        }
        return false;
    }
	
	public boolean checkSubarraySum2(int[] nums, int k) {
	       Set<Integer>dp=new HashSet<>();
	        int sum=0,last=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            int remainder=sum%k;
	            if(dp.contains(remainder)) return true;
	            dp.add(last);
	            last=remainder;
	            sum=remainder;
	        }
	        return false;
	    }
}
