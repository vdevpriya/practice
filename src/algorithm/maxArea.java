package algorithm;

public class maxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,8,6,2,5,4,8,3,7};
		maxArea m = new maxArea();
		System.out.println(m.maxArea(a));
	}
	
	  public int maxArea(int[] height) {
		  int len = height.length;
		  int[][] arr = new int[len][len];
		  int mArea = 0;
		  for(int r=0;r<len;r++)
		  {
			  for(int c=r;c>=r && c<len;c++)
			  {
				  int dist = c-r;
				  int h = Math.min(height[r],height[c]);
				  int area = dist * h;
				  arr[r][c] = area;
				  if(area>mArea)
					  mArea = area;
			  }
		  }
		  return mArea;
	   }
	  
	  public int maxArea2(int[] height) {
		 int left = 0;
		 int right = height.length -1;
		 int maxArea = 0;
		 while(left<right)
		 {
			 int minH = Math.min(height[left], height[right]);
			 int area = right-left * (minH);
			 maxArea = Math.max(area, maxArea);
			 if(height[left]==minH)
				 left++;
			 else
				 right--;
		 }
		 return maxArea;
	   }

}
