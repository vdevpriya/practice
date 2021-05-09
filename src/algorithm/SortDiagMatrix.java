package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortDiagMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		SortDiagMatrix ins = new SortDiagMatrix();
		System.out.println(Arrays.deepToString(ins.diagonalSort(mat)));
	}
	
public int[][] diagonalSort(int[][] mat) {
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {

//In index i, j --> All the diagnoals have same value while we subtract  (i-j) 
                
            // [0,0][0,1][0,2][0,3]
            // [1,0][1,1][1,2][1,3]
            // [2,0][1,1][2,2][2,3]
            // [3,0][3,1][3,2][3,3]    
                
                // we can consider i-j as key due to as its uniqe to every diagnoal. 
                int keyy = i - j;
                if (map.containsKey(i - j))
                    map.get(keyy).add(mat[i][j]);
                else {
                    map.put((keyy), new PriorityQueue());
                    map.get(keyy).add(mat[i][j]);
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int keyy = i - j;
                mat[i][j] = map.get(keyy).poll();
            }
           
        }
        return mat;
    }

}
