package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Combinations {
	
	Map<Set<Integer>,Set<Set>> dpMap = new HashMap<>();
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));
	}
	
	List<List<Integer>>combinations;
	
    void find(int k,int n,List<Integer>combination,int index){
        if(k==0){
            combinations.add(new ArrayList<>(combination));
            return ;
        }
        if(index>n)return ;
        for(int i=index;i<=n;i++){
            combination.add(i);
            find(k-1,n,combination,i+1);
            combination.remove(combination.size()-1);
        }
        return ;
    }
    public List<List<Integer>> combine(int n, int k) {
       combinations=new ArrayList<>();
        find(k,n,new ArrayList<>(),1);
        return combinations;
}

//	
//	public List<List<Integer>> combine(int n, int k) {
//		LinkedHashSet<Integer> s = new LinkedHashSet<>();
//        IntStream.range(1, n+1).forEach(nbr -> {
//        		s.add(nbr);
//        });
//        System.out.println(s);
//        Set<Set> combinationSet = combination(s, k);
//        List<List<Integer>> ll = new ArrayList<>();
//        for(Set si:combinationSet) {
//        		List l = new ArrayList<Integer>(si);
//        		ll.add(l);
//        }
//        return ll;
//    }
//	
//	public Set<Set> combination(LinkedHashSet<Integer> nums,int k) {
//		Set<Set> masterSet = new HashSet<>();
//		if(nums.size()==k) {
//			Set<Integer> numsclone = new HashSet<>();
//			numsclone.addAll(nums);
//			masterSet.add(numsclone);
//			return masterSet;
//		}
//		if(k==1) {
//			Set<Integer> s;
//			for(Integer i:nums) {
//				s = new HashSet<>();
//				s.add(i);
//				masterSet.add(s);
//			}
//			return masterSet;
//		}
//		if(dpMap.containsKey(nums)) {
//			return dpMap.get(nums);
//		}
//		Integer[] arr = nums.toArray(new Integer[nums.size()]);
//		for(int i=0;i<arr.length;i++) {
//			nums.remove(arr[i]);
//			Set<Set> s = combination(nums, k-1);
//			for(Set si: s) {
//				si.add(arr[i]);
//			}
//			if(!dpMap.containsKey(nums)) {
//				dpMap.put((Set)nums.clone(), s);
//			}
//			masterSet.addAll(s);
//			nums.add(arr[i]);
//		}
//		return masterSet;
//	}
}
