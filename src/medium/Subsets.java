package medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
	 List<List<Integer>> answer = new LinkedList<List<Integer>>();
	
	public List<List<Integer>> subsets(int[] nums) {
        findSubset(nums, 0, new LinkedList<>());
        return answer;
    }
	
	 void findSubset(int[] nums,int start,List<Integer> subset) {
		if(start>=nums.length) {
			answer.add(new LinkedList(subset));
			return;
		}
		answer.add(new LinkedList(subset));
		for(int i=start;i<nums.length;i++) {
			subset.add(nums[i]);
			findSubset(nums, i+1, subset);
			subset.remove(((Integer)nums[i]));
		}
	}

}
