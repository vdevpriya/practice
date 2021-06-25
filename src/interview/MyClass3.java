package interview;

import java.util.HashSet;
import java.util.Set;

public class MyClass3 {
	
	static Set<Character> numSet = new HashSet<>();
	int currIdx = 0;
	
	static {
		numSet.add('1');numSet.add('2');
		numSet.add('3');numSet.add('4');
		numSet.add('5');numSet.add('6');
		numSet.add('7');numSet.add('8');
		numSet.add('9');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ex = "a2[b3[c]2[d]]";
		String ex3 = "a2[bc]2[d]";
		String ex2 = "d2[2[a]3[s2[w]]]";
		MyClass3 t = new MyClass3();
		
		System.out.println(t.expandString(ex.toCharArray(), 0));
		System.out.println(t.expandString(ex2.toCharArray(), 0));
		System.out.println(t.test(ex3));
	}
	
	String test(String s) {
		return expandString(s.toCharArray(), 0);
	}
	
	
	String expandString(char[] strChars,int start) {
		if(start>=strChars.length)
			return "";
		
		StringBuilder baseString = new StringBuilder();
		int i = start;
		while(i<strChars.length && strChars[i]!=']') {
			if(numSet.contains(strChars[i])) {
				String subStr = expandString(strChars, i+2);
				int replF = Integer.parseInt(String.valueOf(strChars[i]));
				for(int j=0;j<replF;j++) {
					baseString.append(subStr);
				}
				i=currIdx;
				continue;
			} else {
				baseString.append(strChars[i]);
			}
			i++;
		}
		currIdx=i+1;
		return baseString.toString();
		
	}

}
