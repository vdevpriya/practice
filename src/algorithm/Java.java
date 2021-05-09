package algorithm;

public class Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		System.out.println("rows:"+rows);
		System.out.println("cols:"+cols);
		int[] topSkyLine = new int[cols];
		int[] leftSkyLine = new int[rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] > leftSkyLine[i]) {
					leftSkyLine[i] = grid[i][j];
				}
			}
		}

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (grid[j][i] > topSkyLine[i]) {
					topSkyLine[i] = grid[j][i];
				}
			}
		}

		int totalIncrease = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int temp = grid[i][j];
				int min = Math.min(leftSkyLine[i], topSkyLine[j]);
				if (temp < min) {
					grid[i][j] = min;
					totalIncrease += (min - temp);
				}
			}
		}

		return totalIncrease;

	}

}
