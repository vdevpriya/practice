package algorithm;

import java.util.Stack;

public class ReverseString {
		
	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(reverseWords(s));
	}
	
	public static String reverseWords(String s) {
		 s = s.trim();
		 String[] arr = s.split(" ");
		Stack<String> stack = new Stack<>();
		for (String string : arr) {
			System.out.println(string.trim());
           if(!string.trim().equalsIgnoreCase(""))
			    stack.push(string);
		}
		s = "";
		while(!stack.isEmpty()) {
			s +=" "+stack.pop(); 
		}
		return s.trim();
	  }

}
