package datastructures;

public class division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		division d = new division();

		System.out.println(d.divide(2147483647,2));
	}
	    public int divide(int dividend, int divisor) {
			//Hi. The problem statement has following lines
			//" For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows."
			//And this overflow can occur in only one way that is if we divide Integer.MIN_VALUE by -1. which makes it (Integer.MAX_VALUE +1).
			//By the way:-
			//Integer.MIN_VALUE= -2147483648
			//Integer.MAX_VALUE= 2147483647
			//So by this line of code i have checked the overflow condition.
			    if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
			    if(divisor==1)return dividend;

			    int count=0;
			    int divi=Math.abs(dividend);
			    int div=Math.abs(divisor);
			    while((divi-div)>=0){
			        if(count==Integer.MAX_VALUE)return Integer.MAX_VALUE;
			        else count++;
			        divi-=div;
			    }
			    if((divisor<0 && dividend>=0) || (divisor>=0 && dividend<0))return count*(-1);
			    return count;
			    
			}
}
