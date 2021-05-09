package datastructures;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int rows = in.nextInt();
		int[][] arr = new int[n][5];
		int y = in.nextInt();
		for(int i= 0;i<rows;i++)
		{
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
			arr[i][3] = in.nextInt();
			arr[i][4] = in.nextInt();
		}
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<rows;i++)
		{
			for(int j=i+1;j<rows;j++)
			{
				if(overlap(arr[i][0],arr[i][1],arr[i][2],arr[i][3],arr[j][0],arr[j][1],arr[j][2],arr[j][3]))
				{
					set.add(i);
					set.add(j);
				}
			}
		}
		Long area;
		Long cost = 0l;
		for(Integer i:set)
		{
			area = (long) ((arr[i][2]-arr[i][0])*((arr[i][3]-arr[i][1])));
			cost += area*arr[i][4];
		}
		System.out.println(cost);
		
	}
	static boolean overlap(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		if(x3>x2 || x4<x1)
			return false;
		if(y4<y1 || y3>y2)
			return false;
		return true;
	}

}
