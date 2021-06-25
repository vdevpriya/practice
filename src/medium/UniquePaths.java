package medium;

public class UniquePaths {
	
	static int[][] visited;
	
	public int uniquePaths(int m, int n) {
        visited = new int[m][n];
        return getuniquePaths(0, 0, m, n);
    }
	
	int getuniquePaths(int r,int c,int m, int n) {
		if(r==m-1 && c==n-1)
			return 1;
		int p=0;
		if(visited[r][c]!=0) {
			return visited[r][c];
		}
		if(r+1<m) {
			p = getuniquePaths(r+1, c, m, n);
		}
		if(c+1<n) {
			p+= getuniquePaths(r, c+1, m, n);
		}
		visited[r][c]=p;
		return p;
	}

}
