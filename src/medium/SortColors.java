package medium;

public class SortColors {

	public void sortColors(int[] nums) {
		int left=0;
		int right=nums.length-1;
		for(int i=left;i<=right && left<right && i<nums.length;) {
			if(nums[i]==1) {
				i++;
				continue;
			}
			if(nums[i]==0) {
				if(i<=left) {
					i++;
					left=i;
					continue;
				}
				int t = nums[left];
				nums[left]=0;
				nums[i]=t;
				left++;
			}
			if(nums[i]==2) {
				if(i>=right)
					break;
				int t = nums[right];
				nums[right]=2;
				nums[i]=t;
				right--;
			}
		}
    }
}
