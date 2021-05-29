package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CombinationSum2 c = new CombinationSum2();
		int[] n = {1,1,2,5,6,7,10};
		System.out.println(c.combinationSum2(n,8));	
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		combinationSumFrom(new LinkedList<>(),target,0,candidates);
		Set<List<Integer>> set = new HashSet<>();
		set.addAll(answer);
		answer = new  ArrayList<List<Integer>>();
		answer.addAll(set);
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
			combinationSumFrom(list,target-candidates[i],i+1,candidates);
			list.remove(list.size()-1);
		}
	}

}
