package datastructures;


public class Power {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power test = new Power();
		try {
			System.out.println(test.myPow(0.2, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double myPow(double x, int n) {
		if(x==0)
			return 0;
		if(n==0)
			return 1;
		if(n==1)
			return x;
		
		double temp = myPow(x, n/2);
		if(n%2==0) {
			return temp*temp;
		} else {
			if(n>0) {
				return temp*temp*x;
			} else {
				return (temp*temp)/x;
			}
		}
    }
	
//	public double power(double x,int n) {
//		//return addSelfNtimes(power(x,n-1), x-1);
//		if(n==1)
//			return x;
//		return x * power(x, n-1);
//	}
//	
//	public double addSelfNtimes(double x, int n) {
//		if(n==0)
//			return x;
//		else {
//			return (x + addSelfNtimes(x, n-1));
//		}
//	}


}
