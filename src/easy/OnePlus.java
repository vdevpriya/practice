package easy;

public class OnePlus {
	
	public int[] plusOne(int[] digits) {
        return addOne(digits, digits.length-1);
    }
	int[] addOne(int[] digits, int pos) {
		if(pos<0) {
			return digits;
		}
		if(digits[pos]<9) {
			digits[pos] += 1;
			return digits;
		}
		if(pos>0) {
				digits[pos] = 0;
				return addOne(digits, pos-1);
		} else {
			int[] digits2 = new int[digits.length+1];
			digits2[0] = 1;
			digits2[1] = 0;
			for(int i=1;i<digits.length;i++) {
				digits2[i+1] = digits[i]; 
			}
			return digits;
		}
	}

}
