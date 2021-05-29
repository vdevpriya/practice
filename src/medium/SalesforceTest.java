package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import javax.swing.text.MaskFormatter;

public class SalesforceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Character a = 'A';
//		int x = a+1;
//		a = (char)x;
//		System.out.println(map.get(23));
		System.out.println(doit(27));
	}
	
	static final Map<Integer,Character> map = new HashMap<>();
	
	static {
		IntStream.range(1, 27).forEach(i-> {
			char x = (char)(i+64);
			map.put(i, x);
		});
		
	}
	
	static List<String> makeCombo(String numStr) {
		List<String> s = new LinkedList<String>();
		
		int n;
		if(numStr==null || numStr=="" || numStr.length()==0) {
			return s;
		}
		if(numStr.length()==1) {
			n = Integer.parseInt(numStr);
			if(map.containsKey(n)) {				
				s.add(String.valueOf(map.get(n)));
			}
			return s;
		} else {
			String zero = null; 
			String s1,s1String;
			List<String> ss = new LinkedList<>();
			if(numStr.length()>1) {
				zero = numStr.substring(1,2);
				if(zero.equals("0")) {
					s1 = numStr.substring(0,2);
					n = Integer.parseInt(s1);
					s1String = String.valueOf(map.get(n));
					s = makeCombo(numStr.substring(2));
					if(s.isEmpty()) {
						ss.add(s1String);
					} else {
						for(int i=0;i<s.size();i++) {
							ss.add(s1String+s.get(i));
						}			
					}
				} else {
					s1 = numStr.substring(0, 1);
					n = Integer.parseInt(s1);
					s1String = String.valueOf(map.get(n));
					s = makeCombo(numStr.substring(1));
					ss = new LinkedList<>();
					if(s.isEmpty()) {
						ss.add(s1String);
					} else {
						for(int i=0;i<s.size();i++) {
							ss.add(s1String+s.get(i));
						}			
					}
					
					if(numStr.length()>=2) {
						s1 = numStr.substring(0,2);
						n = Integer.parseInt(s1);
						if(n>=1 && n<=26) {
							s1String = String.valueOf(map.get(n));
							s = makeCombo(numStr.substring(2));
							if(s.isEmpty()) {
								ss.add(s1String);
							} else {
								for(int i=0;i<s.size();i++) {
									ss.add(s1String+s.get(i));
								}			
							}
						}
					}
				}
			}
			return ss;
		}
	}
	public static int doit(int num) {
	    // Write your code here
		Set<String> set = new HashSet<>();
		String str = String.valueOf(num);
		List<String> s = makeCombo(str);
		s.forEach(st -> {
			set.add(st);
		});
		return set.size();
	   }
}
