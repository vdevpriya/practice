package medium;

import java.util.Stack;

public class ValidParanthesis {
	public static void main(String[] args) {
		String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
		ValidParanthesis test = new ValidParanthesis();
		System.out.println(test.checkValidString2(s));
	}
	
	boolean checkValidString2(String s) {
		Stack<Integer> openBraceStack = new Stack<>();
		Stack<Integer> starStack = new Stack<>();
		char[] charArr = s.toCharArray();
		for(int i=0;i<charArr.length;i++) {
			if(charArr[i]=='(') {
				openBraceStack.push(i);
			}
			else if(charArr[i]==')') {
				//for every open bracket there is a close bracket or star
				if(!openBraceStack.isEmpty()) {
					openBraceStack.pop();
					continue;
				}
				else if(!starStack.isEmpty()) {
					starStack.pop();
					continue;
				}
				return false;
			} else {
				starStack.push(i);
			}
		}
		
		//making sure , for every open bracket there is a star after the open bracket index
		System.out.println(openBraceStack.size()+","+starStack.size());
		int j=0;
		for(int i=0;i<openBraceStack.size();i++) {
			while(j>=starStack.size() || openBraceStack.get(i)>=starStack.get(j)) {
				j++;
				if(starStack.size()<=j) {
					return false;
				}
			}
			j++;
		}
		return true;
	}
	
	boolean checkValidString(String s) {
		int idx = s.indexOf('*');
		if(idx==-1)
			return validParan(s);
		return checkValidString(s.replaceFirst("\\*", "(")) || checkValidString(s.replaceFirst("\\*", ")")) || checkValidString(s.replaceFirst("\\*", ""));
	}
	
	
	boolean validParan(String s) {
		System.out.println("validParan: "+s);
		char[] carr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<carr.length;i++) {
			if(carr[i]=='(') {
				stack.push(carr[i]);
			} else{
				if(stack.isEmpty())
					return false;
				if(stack.pop()!='(')
					return false;
			}
		}
		if(!stack.isEmpty())
			return false;
		
		return true;
	}

}
