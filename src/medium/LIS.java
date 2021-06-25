package medium;


/** https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * */
public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums) {
		int[] lis = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			lis[i]=1;
		}
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j] && lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
				}
			}
		}
		int max=lis[0];
        for(int i=0;i<nums.length;i++) {
            if(lis[i]>max)
                max=lis[i];
        }
		return max;
    }

}
