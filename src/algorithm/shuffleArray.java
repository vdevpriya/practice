package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class shuffleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shuffleArray s = new shuffleArray();
		System.out.println(s.add(10, 'a'));
		s.add(new ArrayList<String>());
	}
	public int add(int i,int j) {
		return 0;
	}
	public int add(long i,long j) {
		return 1;
	}
	public int add(char i,char j) {
		return 2;
	}
	public int add(List<Object> o) {
		return 2;
	}
	
	public int[] shuffle(int[] nums, int n) {
        LinkedList<Integer> ll = new LinkedList<>();
        int j = n/2;
        int i =0;
        for(;i<n;i++) {
        		if(i%2==0 && ll.size()!=0) {
        			ll.add(nums[i]);
        			nums[i] = ll.poll();
        		} else if(i%2!=0) {
        			ll.add(nums[i]);
        			nums[i] = nums[j];
        			j++;
        		}
        }
        while(i<nums.length) {
        		if(i%2==0) {
        			nums[i] = ll.poll();
        		} else {
        			nums[i] = nums[j];
        			j++;
        		}
        }
        
        return nums;
    }
}
