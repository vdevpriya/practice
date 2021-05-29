package easy;

public class AddBinary {

	public String addBinary(String a, String b) {
        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();
        int ai=ar.length-1,bi=br.length-1;
        char s,co='0';
        String r="";
        while(ai>=0 || bi>=0) {
        		char ac = ai>=0 ? ar[ai] : '0';
        		char bc = bi>=0 ? br[bi] : '0';
        		s = addBin(ac, bc);
        		s = addBin(s	, co);
        		r= s+r;
        		co = carryOver(ac, bc, co);
        		ai--;
        		bi--;
        }
        if(co=='1') {
        		return "1"+r;
        }
        return r;
        
    }
	
	char addBin(char a, char b) {
		if(a=='0' & b=='0')
			return '0';
		if((a=='1' && b=='0') || (a=='0' && b=='1')) {
			return '1';
		}
		return '0';
		
	}
	char carryOver(char a,char b,char c) {
		int aa = Integer.parseInt(String.valueOf(a));
		int bb = Integer.parseInt(String.valueOf(b));
		int cc = Integer.parseInt(String.valueOf(c));
		if(aa+bb+cc==3)
			return '1';
		if(aa+bb+cc==2)
			return '1';
		return '0';
		
	}
}
