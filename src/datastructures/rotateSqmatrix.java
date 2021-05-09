package datastructures;

import java.util.Scanner;

public class rotateSqmatrix {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j] = scan.nextInt();
			}
		}
		printArr(arr);
		System.out.println("");
		System.out.println("");
		
		int n_sq = n/2 + n%2;
		
		int cur_start_r = 0;
		int cur_start_c = 0;
		int cur_sq_l = n;
		
		for(int i=1;i<=n_sq;i++)
		{
			rotAntiClock(cur_start_r,cur_start_c,cur_sq_l,arr);
			++cur_start_r;
			++cur_start_c;
			cur_sq_l=cur_sq_l-2;
		}
		
	}

	private static void rotAntiClock(int cur_start_r, int cur_start_c, int cur_sq_l, int[][] arr) {
		// TODO Auto-generated method stub
		if(cur_sq_l==1)
			return;
		int x = arr[cur_start_r][cur_start_c];
		for(int c=cur_start_c;c<cur_start_c+cur_sq_l-1;c++)
		{
				move(cur_start_r,c,arr[cur_start_r][c],cur_sq_l,cur_start_r,cur_start_c,arr,0);
		}
		
		printArr(arr);
	}

	private static void printArr(int[][] arr) {
		// TODO Auto-generated method stub
		int l = arr.length;
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("");
		}
	}

	private static void move(int r, int c, int v, int l,int originR,int originC,int[][] arr,int callN) {
		// TODO Auto-generated method stub
		int steps=l-1;
		if(callN>4)
			return;
		int tmp;
		if(r==originR && c==originC)
		{
			r = r+l-1;
		}
		else if(r==originR+l-1 && c==originC)
		{
			c = c+l-1;
		}
		else if(r==originR+l-1 && c==originC+l-1)
		{
			r = r-l+1;
		}
		else if(r==originR && c==originC+l-1)
		{
			c = c-l+1;
		}
		else if(r==originR && c>originC)
		{
			r = originR + steps - (c-originC);
			c = originC;
		}
		else if(c==originC && r>originR)
		{
			c = originC + steps - (originR+l-1-r);
			r = originR+l-1;
		}
		else if(r==originR+l-1 && c>originC)
		{
			r = (originR+l-1) - (steps - (originC+l-1-c));
			c = originC+l-1;
		}
		else if(c==originC+l-1 && r>originR)
		{
			c = (originC+l-1) - (steps - (r-originR));
			r = originR;
		}
		tmp = arr[r][c];
		arr[r][c] = v;
		++callN;
		move(r, c, tmp, l, originR, originC, arr,callN);
	}

}
