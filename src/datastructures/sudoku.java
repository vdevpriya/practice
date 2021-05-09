package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class sudoku {
	static final HashSet<Integer> setNumbers = new HashSet<>();
	static final Map<Integer, HashSet<Integer>> rowSetMap = new HashMap<Integer, HashSet<Integer>>();
	static final Map<Integer, HashSet<Integer>> colSetMap = new HashMap<Integer, HashSet<Integer>>();
	static final Map<Integer, HashSet<Integer>> subGSetMap = new HashMap<Integer, HashSet<Integer>>();
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int[][] g = new int[9][9];
		
		for (int i = 1; i <= 9; i++)
			setNumbers.add(i);
		
		int subGi = 0;
		HashSet<Integer> setR = null;
		HashSet<Integer> setC = null;
		HashSet<Integer> setG = null;

		int ele = 0;
		for (int i = 0; i < 9; i++) {
			setR = new HashSet<Integer>();
			rowSetMap.put(i, setR);
			for (int j = 0; j < 9; j++) {
				subGi = getSubGI(i, j);

				ele = s.nextInt();
				g[i][j] = ele;
				if(ele==0)
					continue;
				if (subGSetMap.get(subGi) == null) {
					setG = new HashSet<>();
					subGSetMap.put(subGi, setG);
				} else {
					setG = subGSetMap.get(subGi);
				}

				if (colSetMap.get(j) == null) {
					setC = new HashSet<>();
					colSetMap.put(j, setC);
				} else {
					setC = colSetMap.get(j);
				}

				setR.add(ele);
				setC.add(ele);
				setG.add(ele);
			}
		}
		printArr(g);
		System.out.print("\n");
		for (Entry e : rowSetMap.entrySet()) {
			System.out.print("Row:"+e.getKey()+"=>");
			for (Integer integer : (Set<Integer>)e.getValue()) {
				System.out.print(integer+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for (Entry e : colSetMap.entrySet()) {
			System.out.print("Col:"+e.getKey()+"=>");
			for (Integer integer : (Set<Integer>)e.getValue()) {
				System.out.print(integer+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for (Entry e : subGSetMap.entrySet()) {
			System.out.print("Grid:"+e.getKey()+"=>");
			for (Integer integer : (Set<Integer>)e.getValue()) {
				System.out.print(integer+" ");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		fillSudoku(g);
		System.out.println("\n\n");
		printArr(g);
	}

	private static int fillSudoku(int[][] g) {
		// TODO Auto-generated method stub
		for(int i=0;i<=8;i++)
		{
			for(int j=0;j<=8;j++)
			{
				System.out.println("r= "+i+" c="+j);
				if (g[i][j] != 0)
					continue;
				HashSet<Integer> setR = rowSetMap.get(i);
				HashSet<Integer> setC = colSetMap.get(j);
				HashSet<Integer> setG = subGSetMap.get(getSubGI(i, j));
				Set<Integer> allowedDigits = new HashSet<Integer>(setNumbers);
				Set<Integer> notallowedDigits = new HashSet<Integer>(setR);
				notallowedDigits.addAll(setC);
				notallowedDigits.addAll(setG);
				allowedDigits.removeAll(notallowedDigits);
				
				if(allowedDigits.isEmpty())
					return -1;
				else
				{
					System.out.println("allowedDigits for " +"r= "+i+" c="+j);
					for (Integer integer : allowedDigits) {
						System.out.print(integer +" ");
					}
					System.out.print("\n");
					for (Integer integer : allowedDigits) {
						System.out.println("Putting "+integer +" at r= "+i+" c="+j);
						g[i][j] = integer;
						setC.add(integer);
						setR.add(integer);
						setG.add(integer);
						printArr(g);
						if(fillSudoku(g)==-1)
						{
							System.out.println("Removing "+integer +" at r= "+i+" c="+j);
							
							setC.remove(integer);
							setR.remove(integer);
							setG.remove(integer);
							g[i][j] = 0;
							printArr(g);
							continue;
						}
						break;
					}
					if(g[i][j]==0)
					{
						System.out.println("Exhausted all options");
						return -1;
					}
				}
			}
		}
		System.out.println("Returning 1");
		return 1;
		
	}

	private static void printArr(int[][] arr) {
		// TODO Auto-generated method stub
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	private static int getSubGI(int i, int j) {
		if (j >= 6) {
			if (i >= 6)
				return 8;
			else if (i >= 3)
				return 5;
			else
				return 2;
		} else if (j >= 3) {
			if (i >= 6)
				return 7;
			else if (i >= 3)
				return 4;
			else
				return 1;
		} else if (j >= 0) {
			if (i >= 6)
				return 6;
			else if (i >= 3)
				return 3;
			else
				return 0;
		} else
			return -1;
	}
}
