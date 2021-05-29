package easy;

public class Sqrt {
	
	public static void main(String[] args) {
		Sqrt t = new Sqrt();
		System.out.println(t.mySqrt(2147395599));
	}
	
	public int mySqrt(int x) {
		if(x==1)
    	  		return 1;
		
		long start = 2;
		long end = x;
		long mid = start + (end-start)/2;
		long sq = mid*mid;
		while(start<=end) {
			if(sq==x)
				return (int)mid;
			start = x>sq?mid+1:start;
			end = x<sq?mid-1:end;
			mid = start + (end-start)/2;
			sq = mid*mid;
		}
		return (int)end;
	}

}
