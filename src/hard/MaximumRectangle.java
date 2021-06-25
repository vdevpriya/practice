package hard;

import java.util.Stack;

public class MaximumRectangle {
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		//char[][] matrix = {{'1','0'}};
		MaximumRectangle m = new MaximumRectangle();
		System.out.println(m.maximalRectangle(matrix));
	}
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0)
            return 0;
		int[][] histogram = new int[matrix.length][matrix[0].length];
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				histogram[i][j] = (matrix[i][j]=='0')?0: 1+(i>0?histogram[i-1][j]:0);
			}
		}
		int max = -1;
		for(int i=0;i<histogram.length;i++) {
			int[] h = histogram[i];
			int[] nsl = findNSL(h);
			int[] nsr = findNSR(h);
			for(int j=0;j<nsl.length;j++) {
				int a = (nsr[j]-nsl[j]-1)*h[j];
				if(a>max) {
					max = a;
				}
			}
		}
		return max;
        
    }
	
	 public int maximalSquare(char[][] matrix) {
		 if(matrix.length==0)
	            return 0;
			int[][] histogram = new int[matrix.length][matrix[0].length];
			
			for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					histogram[i][j] = (matrix[i][j]=='0')?0: 1+(i>0?histogram[i-1][j]:0);
				}
			}
			int max = -1;
			for(int i=0;i<histogram.length;i++) {
				int[] h = histogram[i];
				int[] nsl = findNSL(h);
				int[] nsr = findNSR(h);
				for(int j=0;j<nsl.length;j++) {
					int l = (nsr[j]-nsl[j]-1);
					int b = h[j];
					l = Math.min(l, b);
					int a = l*l;
					if(a>max) {
						max = a;
					}
				}
			}
			return max;
	}
	
	public int largestRectangleArea(int[] heights) {
		int max = -1;
		int[] nsl = findNSL(heights);
		int[] nsr = findNSR(heights);
		for(int j=0;j<nsl.length;j++) {
			int a = (nsr[j]-nsl[j]-1)*heights[j];
			if(a>max) {
				max = a;
			}
		}
		return max;
    }
	
	int[] findNSL(int[] arr) {
		int[] nsl = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			nsl[i] = stack.isEmpty()?-1:stack.peek();
			stack.push(i);
		}
		return nsl;
	}
	
	int[] findNSR(int[] arr) {
		int[] nsr = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			nsr[i] = stack.isEmpty()?arr.length:stack.peek();
			stack.push(i);
		}
		return nsr;
	}
	
	int[] findNGL(int[] arr) {
		int[] ngl = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			
			ngl[i] = st.isEmpty()? -1: st.peek();
			st.push(i);
		}
		
		return ngl;
	}
	
	int[] findNGR(int[] arr) {
		int[] ngr = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		
		for(int i=arr.length;i>=0;i--) {
			while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			
			ngr[i] = st.isEmpty()? arr.length: st.peek();
			st.push(i);
		}
		
		return ngr;
	}
	
	
}

