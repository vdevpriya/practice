package datastructures;

import java.util.Scanner;

public class countOfStrings {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int bfreq = 1;
		int cfreq = 2;
		int afreq ;	
		int count = 0;
		//int totalL = 4;
		for(int i=0;i<=bfreq;i++)
		{
			for(int j=0;j<=cfreq;j++)
			{
				afreq = l - i - j;
				count += numOfComb(afreq, i, j);
			}
		}
		System.out.println(count);
		
	}
	static int numOfComb(int as,int bs,int cs)
	{
		return (fact(as+bs+cs)/(fact(as)*fact(bs)*fact(cs)));
	}
	static int fact(int x)
	{
		if(x==1 || x==0)
			return 1;
		return x*fact(x-1);
	}
}
