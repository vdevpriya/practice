package algorithm;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int reverse(int x) {
	        long reversed = 0;
	        while(x > 0)
	        {
	            reversed = (reversed*10) + (x%10);
	            x /= 10;
	        }
	        if(reversed > Integer.MAX_VALUE)
	        {
	        		return 0;
	        } else {
	        		return (int)reversed;
	        }
	    }

}

//
//class Solution {
//    public int reverse(int x) {
//        long reversed = 0;
//        while(x > 0)
//        {
//            reversed = (reversed*10) + (x%10);
//            x /= 10;
//        }
//        if(revesed > MATH.)
//    }
//}