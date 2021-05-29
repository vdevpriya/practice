package easy;

public class LastWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lengthOfLastWord(String s) {
	        if(s.trim().length()==0) {
	        		return 0;
	        }
	        int count = 0;
	        s = s.trim(); 
	        for(int i=0;i<s.trim().length();i++) {
	        		if(s.charAt(i) != ' ') {
	        			count++;
	        		} else {
	        			count = 0;
	        		}
	        }
	        return count;
	    }

}
