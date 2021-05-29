package medium;

import java.util.Arrays;

public class RotatedArray {
	
	public static void main(String[] args) {
		int[] n = {1};
		RotatedArray t = new RotatedArray();
		System.out.println(t.search(n, 0));
	}
	
	public int search(int[] nums, int target) {
		if(nums.length==0)
			return -1;
		if(nums.length==1){
			if( nums[0]==target)
				return 0;
			else
				return -1;
		}
		int c = checkOrder(nums, 0, nums.length-1);
		if(c==0) {
			int pivot = searchPivot(nums, 0, nums.length-1);
			if(pivot==-1)
				return -1;
			int k = Arrays.binarySearch(nums,0,pivot+1,target);
			if(k<0)
				k = Arrays.binarySearch(nums,pivot+1,nums.length,target);
			
			return k<0?-1:k;
		}
		int l=-1;
		if(c==1)
			l = Arrays.binarySearch(nums, target);
		return l<0?-1:l;
    }
	
	public int searchPivot(int[] nums,int start,int end) {
		if(end==start+1 && nums[start]>nums[end]) {
			return start;
		}
		int c = checkOrder(nums, start, end);
		if(c==0) {
			int mid = (start+end)/2;
			int k = searchPivot(nums, start,mid);	
			if(k!=-1)
				return k;
			int l =  searchPivot(nums, mid,end);
			return l;
		}
		
		return -1;
	}
	
		int checkOrder(int[] nums,int start,int end) {
			//pivot exists in this range
			if(nums[start] >= nums[end])
				return 0;
			//only inc
			else
				return 1;
					
			}
}
