package algorithm;

public class DisticntBinryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisticntBinryTrees o = new DisticntBinryTrees();
		System.out.println(o.numTrees(2));
	}
	
//	 public int numTrees(int n) {
//		 if(n==1 || n==0)
//			 return 1;
//		 if(n==2)
//			 return 2;
//		 
//		 int numtrees = 0;
//		 for(int i=0;i<n;i++)
//		 {
//			 numtrees += numTrees(i)*numTrees(n-1-i);
//		 }
//		 return numtrees;
//	  }
//	 
	 public int numTrees(int n) {
		 if(n==0)
			 return 0;
		 
		 int[][] arr = new int[n][n];
		 arr[0][0] = 1;
		 int row = 1;
		 int col = 0;
		while(row<n)
		{
			col = 0;
			while(row+col<=n) {
				if(col==0) {
					int x = row-1;
					int y = 0;
					int s = 0;
					while(x>=0 && x>=y) {					
						s += ((x==y?1:2)*arr[x][y]);
						x-=1;
						y+=1;
					}
					arr[row][0] = s;
				} else {
					arr[row][col] = arr[row][0] * arr[col][0];
				}
				col++;
			}
			row++;
		}
		
		int x = n-1;
		int y = 0;
		int s = 0;
		while(x>=0 && x>=y) {					
			s += ((x==y?1:2)*arr[x][y]);
			x-=1;
			y+=1;
		}
		return s;
		
	 }

}
