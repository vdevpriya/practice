package easy;

public class SqresSortedArr {
	
	public int[] sortedSquares(int[] nums) {
		boolean allnegative = true;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0)
				allnegative=false;
			nums[i] = nums[i]*nums[i];
		}
		if(nums.length==0 || nums.length==1)
			return nums;
		
		int left=0;
		int right=nums.length-1;
		if(allnegative) {
			while(left<right) {
				int x = nums[right];
				nums[right]=nums[left];
				nums[left]=x;
				left++;
				right--;
			}
			return nums;
		}
		left=0;
		right=nums.length-1;
		int[] nums2 = new int[nums.length];
		for(int i=0;i<nums.length && left<right;i++) {
			if(nums[left]>nums[right]) {
				nums2[nums.length-1-i] = nums[left];
				left++;
			} else {
				nums2[nums.length-1-i] = nums[right];
				right--;
			}
		}
		return nums2;
    }

}
