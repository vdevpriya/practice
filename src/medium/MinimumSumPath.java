package medium;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 * */
public class MinimumSumPath {
	
	public static void main(String[] args) {
		int[][] m = {
				{1,3,1},
				{1,5,1},
				{4,2,1}};
		MinimumSumPath test = new MinimumSumPath();
		System.out.println(test.minPathSum(m));
	}
	
	public int minPathSum(int[][] grid,int startR,int startC,int endR,int endC) {
		if(startR>=grid.length || startC>=grid[0].length)
			return 1000000000;
		
        if(startR==endR && startC==endC) {
        		return grid[startR][startC];
        }
        else {
        		return grid[startR][startC]+Math.min(minPathSum(grid, startR+1, startC, endR, endC),
        				minPathSum(grid, startR, startC+1, endR, endC));
        }
    }
	
	public int minPathSum(int[][] grid) {
		ConcurrentLinkedQueue<Entry> set = new ConcurrentLinkedQueue<>();
		
		int[][] pathGrid = new int[grid.length][grid[0].length];
		for(int i =0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				pathGrid[i][j] = 1000000000;
			}
		}
		pathGrid[0][0] = grid[0][0];
		set.add(new Entry(0, 0));
		while(!set.isEmpty()) {
			Entry e = set.poll();
			int pathSum;
			if(e.row+1<pathGrid.length) {
				Entry downEl = new Entry(e.row+1, e.col);
				pathSum = pathGrid[e.row][e.col] + grid[downEl.row][downEl.col];
				if(pathSum<pathGrid[downEl.row][downEl.col]) {
					pathGrid[downEl.row][downEl.col] = pathSum;
				}
				set.add(downEl);
			}
			if(e.col+1<pathGrid[0].length) {
				Entry rightEl = new Entry(e.row, e.col+1);
				pathSum = pathGrid[e.row][e.col] + grid[rightEl.row][rightEl.col];
				if(pathSum<pathGrid[rightEl.row][rightEl.col]) {
					pathGrid[rightEl.row][rightEl.col] = pathSum;
				}
				set.add(rightEl);
			}
			//set.remove(e);
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(pathGrid[i][j] +"-");
			}
			System.out.println("");
		}
		return pathGrid[grid.length-1][grid[0].length-1];
	}
	
	class Entry {
		int row;
		int col;
		public Entry(int r,int c) {
			// TODO Auto-generated constructor stub
			this.row = r;
			this.col = c;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Entry ob = (Entry) obj;
			return (ob.row==this.row && ob.col==this.col);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return (row*row)+(col*col);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(this.row)+","+String.valueOf(this.col);
		}
	}
}
