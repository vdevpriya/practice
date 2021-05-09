package algorithm;

import java.util.Scanner;

public class longestPalSubstring2 {

	static int maxPalindromeSubtringLength = 0;
    static int[][] palindromeTracker;
    
    public static String longestPalindrome(String s) {
        if(s==null || s.trim()==null || s.length()==0)
            return "";
        
        char[] letters = s.toCharArray();
        
        int strLength = s.length();
        palindromeTracker = new int[strLength][strLength];
        int rowMax = 0, colMax = 0;
        
        for(int len = 1; len <= strLength; len++)
        {
            for(int row=0;row+len-1 < strLength; row++)
            {
                int col = row+len-1;
                if(row==col)
                {
                    palindromeTracker[row][col] = 1;
                }
                else if(row+1 <= col-1)
                {
                		System.out.println(letters[row]==letters[col]);
                    palindromeTracker[row][col] = (letters[row]==letters[col] && palindromeTracker[row+1][col-1]==1 ? 1 : 0);
                } else {
                		palindromeTracker[row][col] = (letters[row]==letters[col] ? 1 : 0);
                }
                 if(palindromeTracker[row][col]==1 && len > (rowMax-colMax+1))
                {
                    rowMax = row;
                    colMax = col;
                }
            }
        }
        	for(int i=0;i<palindromeTracker.length;i++)
        	{
        		for(int j=i;j<palindromeTracker.length;j++)
        		{
        			System.out.print(palindromeTracker[i][j]);
        		}
        		System.out.println("");
        	}
        return s.substring(rowMax,colMax+1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(longestPalSubstring2.longestPalindrome(s));
	}
	
}