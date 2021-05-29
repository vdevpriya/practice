package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute {
	
	public static void main(String[] args) {
		int[] x = {1,2,3};
		Permute m = new Permute();
		List<List<Integer>> l =m.permute(x);
		//LinkedHashSet<MyList<Integer>> l = new LinkedHashSet<>();
		for(int i=0;i<l.size();i++) {
			for(int j=0;j<l.get(i).size();j++) {
				System.out.print(l.get(i).get(j)+",");
			}
			System.out.println("");
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
        LinkedList<Integer> l = new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
        		l.add(nums[i]);
        }
        return permute(l);
    }
	
	public  List<List<Integer>> permute(LinkedList<Integer> nums) {
		List<List<Integer>> l = new LinkedList<>();
		if(nums.size()==1) {
			List<Integer> l1 = new LinkedList<>();
			l1.addAll(nums);
			l.add(l1);
			return l;
		}
		int k = nums.size();
		Integer lastPr = null;
		for(int j=0;j<k;j++) {			
			int x = nums.remove(k-j-1);
			if(lastPr!=null && lastPr==x) {
				nums.add(k-j-1, x);
				continue;
			}
			List<List<Integer>> l1 = permute(nums);
			for(int i=0;i<l1.size();i++) {
				List<Integer> curr = l1.get(i);
				curr.add(x);
				l.add(curr);
			}
			nums.add(k-j-1, x);
			lastPr = x;
		}
		return l;
	}

}

//class MyList<T> extends LinkedList<T> {
//	public boolean equals(Object l2) {
//		MyList l = (MyList) l2;
//		if(this.isEmpty() && l.isEmpty()) {
//			return true;
//		}
//		if(l.get(0).equals(this.get(0))) {
//			T o1 = (T) l.remove(0);
//			T o2 = this.remove(0);
//			boolean x = this.equals(l);
//			l.add(0, o1);
//			this.add(0, o2);
//			return x;
//		}
//		return false;
//	}
//	public int hashcode() {
//		
//	}
//}
