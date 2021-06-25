package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABC";
		int[] arr = {1,2,3,4};
		MyClass2 m = new MyClass2();
		//System.out.println(m.pthFactor(67280421310721,2));

	}
	public static boolean canConstructLetter(String text, String note) {
	    // Write your code here
		Map<Character,Integer> m = new HashMap<>();
		for(int i=0;i<text.length();i++) {
			char c = text.charAt(i);
			if(c==' ')
				continue;
			m.put(c, m.getOrDefault(c, 0)+1);
			
		}
		for(int i=0;i<note.length();i++) {
			if(!m.containsKey(note.charAt(i)))
				return false;
			m.put(note.charAt(i), m.get(note.charAt(i))-1);
		}
		return true;
	  }
	
	public static long pthFactor(long n, long p) {
        // Write your code here
		System.out.println(n+","+p);
            Set<Long> s = new HashSet<>();
            if(n==1) {
                if(p>1)
                    return 0;
                return 1;
            }
            long f = n;
            long i=1;
            while(i<f) {
                if(n%i==0) {
                    s.add(i);
                    s.add(n/i);
                    f = n/i;
                }
                i++;
            }
            Long[] larr = s.toArray(new Long[s.size()]);        
            if(p>larr.length) {
                return 0;
            }
            Arrays.sort(larr);
            return larr[(int)p-1];
        }
}
