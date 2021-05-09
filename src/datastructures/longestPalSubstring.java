package datastructures;

import java.util.Scanner;

public class longestPalSubstring {
    Boolean[][] dpArr;
    int m_left =-1;int m_right = -1;
    
    public static void main(String[] args) {
    	//babaddtattarrattatddetartrateedredividerb
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("Input is :"+s);
		longestPalSubstring ins = new longestPalSubstring();
		System.out.println("longest palindrome:"+ins.longestPalindrome(s));
	}
    public String longestPalindrome(String s) {
    		if(s==null)
			return null;
    		if(s.trim().length()==0)
    			return s;
        int len = s.length();
        dpArr = new Boolean[len][len];
        char[] arr = s.toCharArray();
        checkPalindrome(0, len-1, arr);
        if(m_left==-1)
        {
        		return s.substring(0,1);
        } else {
        		return s.substring(m_left,m_right+1);
        }
    }
    public void checkPalindrome(int l,int r,char[] arr)
    {
    		if(l>r)
    			return;
    		if(isPalindrome(l, r, arr) && ((r-l)>(m_right-m_left))){
    			m_left = l;
    			m_right = r;
    			return ;
    		} else {
    			checkPalindrome(l, r-1, arr);
    			checkPalindrome(l+1, r, arr);
    		}
    }
     public boolean isPalindrome(int left,int right,char[] arr) {
        if(left==right)
        {
        		dpArr[left][right] = true;
            return true;
        }
         else if(left==right-1)
         {
        	 	dpArr[left][right] = (arr[left]==arr[right]);
        	 	return arr[left]==arr[right];
         }
         else if(left<right)
         {
        	 	dpArr[left][right] = (arr[left]==arr[right] && ((dpArr[left+1][right-1]!=null && dpArr[left+1][right-1]==true)  || isPalindrome(left+1,right-1,arr)));
        	 	return dpArr[left][right];
         }
         else {
             return false;
         }
    }
}
