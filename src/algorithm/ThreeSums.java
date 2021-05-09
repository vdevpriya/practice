package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Map<Character, Integer> sortMapByValue(Map<Character, Integer> map){
	     
	    return map.entrySet().stream().sorted(
	      (a,b)->a.getValue()-b.getValue()).collect(Collectors.toMap( ));
	  }
	 public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> ll = new LinkedList<>();
		 List<Integer> list ;
		 Arrays.sort(nums);
	        int i=0;
	        int l, r,s;
	        for(i=0;i<nums.length;i++)
	        {
	        		if(i>0 && nums[i]==nums[i-1])
	        			continue;
	        		l = i+1;
	        		r = nums.length -1;
	        		 while(l<r){
	        			 if(r<nums.length-1 && nums[r]==nums[r+1])
	        			 {
	        				 	r--;
	        			 		continue;
	        			 }
	 	        			s = nums[i]+nums[l]+nums[r];
	 	        			if(s<0)
	 	        			{
	 	        				l++;
	 	        			}
	 	        			else if(s==0)
 	        				{
 	        					list = new LinkedList<>();
 	        					list.add(i);
 	        					list.add(l);
 	        					list.add(r);
 	        					ll.add(list);
 	        					System.out.println(nums[i]+","+nums[l]+","+nums[r]);
 	        					l++;
 	        					r--;
 	        				}
	 	        			else
	 	        			{
	 	        				r--;
	 	        			}
	 	        }
	        }
	       
	        return ll;
	    }

}
