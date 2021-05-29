package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c = new CombinationSum();
		int[] n = {2};
		System.out.println(c.combinationSum(n,1));
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		combinationSumFrom(new LinkedList<>(),target,0,candidates);
		return answer;
	}
	List<List<Integer>> answer = new ArrayList<List<Integer>>();
	
	public void combinationSumFrom(List<Integer> list,int target,int start,int[] candidates) {
		if(target==0) {
			answer.add(new LinkedList<>(list));
			return;
		}
		for(int i=start;i<candidates.length && candidates[i]<=target;i++) {
			list.add(candidates[i]);
			combinationSumFrom(list,target-candidates[i],i,candidates);
			list.remove(list.size()-1);
		}
	}

}
