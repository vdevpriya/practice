package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		//System.out.println(test.isPalindrome(1211));
		//System.out.println(test.romanToInt("MCMXCIV"));
		//System.out.println(test.longestCommonPrefix(new String[]{"Hello","helloWrold"}));
		//System.out.println(test.isValid("()[]{}"));
		//System.out.println(test.removeDuplicates(new int[]{1,1,2,2,3,3,4}));
		System.out.println(test.removeElement(new int[]{},3));
	}
	public boolean isPalindrome(int x) {
        String[] chars = String.valueOf(x).split("");
        int start=0,end=chars.length-1;
        while(start<=end) {
        		if(!chars[start].equals(chars[end])){
        			return false;
        		}
        		start++;
        		end--;
        }
        return true;
    }
	
	public int romanToInt(String s) {
        Map<String,Integer> romanToInt = new HashMap<>();
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);
        romanToInt.put("IV", 4);
        romanToInt.put("IX", 9);
        romanToInt.put("XL", 40);
        romanToInt.put("XC", 90);
        romanToInt.put("CD", 400);
        romanToInt.put("CM", 900);
        
        int l = s.length();
        String key;
        int n=0;
        for(int i=0;i<l;) {
        		if(i+1<l) {
        			key = s.substring(i,i+2);
        			if(!romanToInt.containsKey(key)) {
        				key = s.substring(i, i+1);
        				i++;
        			} else {
        				i=i+2;
        			}
        		} else {
        			key = s.substring(i, i+1);
        			i++;
        		}
        		n += romanToInt.get(key);
        }
        
        return n;
    }

	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];
		for(int i=1;i<strs.length;i++) {
			int j=0;
			while(j<strs[i].length() && j<prefix.length()) {
				if(prefix.charAt(j)!=strs[i].charAt(j)) {
					break;
				}
				j++;
			}
			if(j==0) {
				return "";
			} else {
				prefix = prefix.substring(0,j);
			}
		}
		return prefix;
    }

	public boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<brackets.length) {
        		if(isOpenBracket(brackets[i])) {
        			stack.push(brackets[i]);
        		} else {
        			if(stack.isEmpty() || !matchBrackets(stack.pop(), brackets[i])) {
        				return false;
        			}
        		}
        		i++;
        }
        if(!stack.isEmpty())
        		return false;
        return true;
    }
	
	boolean isOpenBracket(Character b) {
		return (b=='(' || b=='{' || b=='[');
	}
	boolean isCloseBracket(Character b) {
		return (b==')' || b=='}' || b==']');
	}
	boolean matchBrackets(char b1,char b2) {
		return ((b1=='(' && b2==')') || (b1=='{' && b2=='}') || (b1=='[' && b2==']'));
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode m, mhead, temp = null;
		if (p1.val <= p2.val) {
			mhead = m = p1;
			p1 = p1.next;
		} else {
			mhead = m = p2;
			p2 = p2.next;
		}
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				temp = p1;
				p1 = p1.next;
				m.next = temp;
			} else {
				temp = p2;
				p2 = p2.next;
				m.next = temp;
			}
			m = m.next;
		}
		if (p1 == null && p2 != null) {
			m.next = p2;
		} else if (p2 == null && p1 != null) {
			m.next = p1;
		}
		return mhead;

	}

	public int removeDuplicates(int[] nums) {
		if(nums.length==1)
			return 1;
		
        int x=1,y=0;
        while(x<nums.length) {
        		while(nums[x]==nums[x-1]) {
        			x++;
        			if(x>=nums.length)
        				return y+1;
        		} 
        		nums[y+1]=nums[x];
        		y++;
        		x++;
        }
        //Arrays.stream(nums).forEach(System.out::println);
        
        return y+1;
    }

	public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length-1;
        int count = 0;
        if(nums.length==0)
        		return 0;
        if(start==end) {
        		if(nums[start]==val)
        			return 0;
        		else
                    return nums.length;
        }
        while(end>start) {
        		while(nums[start]!=val && end>start) {
        			start++;
        		}
        		while(nums[end]==val && end>start) {
        			end--;
        		}
        		if(end>start && nums[start]==val && nums[end]!=val) {
        			nums[start] = nums[end];
        			nums[end] = val;
        			count++;     			
        		}
        }
        //Arrays.stream(nums).forEach(System.out::println);
        //System.out.println(start+","+end+","+nums[end]);
        if(start==end && nums[end]==val) {
        		return end;
        }
        if(start==end && nums[end]!=val) {
        		return end+1;
        }
        return -1;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
