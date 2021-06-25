package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
	  
		List<Integer> list;
		Stack<Integer> s;
	    public StockSpanner() {
	        this.list = new LinkedList<>();
	        s = new Stack<>();
	    }
	    
	    public int next(int price) {
	        list.add(price);
	        int ngl = findNGL(list.toArray(new Integer[list.size()]));
	        return list.size()-1- ngl;
	    }
	    
	    int findNGL(Integer[] arr) {
	    	int i = arr.length-1;
			while(!s.isEmpty() && arr[s.peek()]<=arr[i]) {
				s.pop();
			}
			int ngl = (s.isEmpty()? -1: s.peek());
			s.push(i);
			return ngl;
	    }
	}

	/**
	 * Your StockSpanner object will be instantiated and called as such:
	 * StockSpanner obj = new StockSpanner();
	 * int param_1 = obj.next(price);
	 */