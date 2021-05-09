package algorithm;

import java.util.TreeSet;

public class ContainDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,2147483647};
		int k= 1;
		int t = 2147483647;
		System.out.println(containsNearbyAlmostDuplicate(arr, k, t));
	}
	
	 public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		 if(k==0)
			 return true;
		 if(nums.length==0)
			 return false;
		 
		 long t1 = (long)t;
		 TreeSet set = new TreeSet<Long>();
		 set.add((long)nums[0]);
		 long val;
		 for(int i=1;i<nums.length;i++)
		 {
			 if(set.size()>k)
				 set.remove(nums[i-k-1]);
			 val = nums[i];
			 Long f = (Long) set.floor(val);
			 Long c = (Long) set.ceiling(val);
			 if(f!=null &&  val-f<=t1)
			 {
				 return true;
			 }
			 if(c!=null &&  c-val<=t1)
			 {
				 return true;
			 }
			 set.add(val);
		 }
		 return false;
	 }

}
