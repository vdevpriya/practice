package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MyClass {
	
	Stack<Node> stack = new Stack<>();
	List<Node> q = new LinkedList<>();
	int level = 0;
	
	int[] getColArr(int[][] sortedMatrix,int col) {
		int[] arr = new int[4];
		for(int i=0;i<4;i++) {
			arr[i] = sortedMatrix[i][col];
		}
		return arr;
	}

	int findElement(int[][] sortedMatrix, int el) {
		int index = -1;
		int colIndex = findColumn(el, sortedMatrix);
		if(sortedMatrix[0][colIndex]==el) {
			return el;
		} else {
			int[] arr = getColArr(sortedMatrix, colIndex);
			index = Arrays.binarySearch(arr, el);
			if(index>0)
				return el;
		}
		int row = findRow(el, sortedMatrix);
		if(sortedMatrix[row][0]==el) {
			return el;
		} else {
			int[] arr = sortedMatrix[row];
			index = Arrays.binarySearch(arr, el);
			if(index>0)
				return el;
		}
		return index;
	}
	
	int findColumn(int el, int[][] sortedMatrix) {
		int[] arr = sortedMatrix[0];
		int k = Arrays.binarySearch(arr, el);
		return getIndex(arr, k);
	}
	
	int getIndex(int[] arr,int k) {
		if(k>0) {
			return k;
		} else {
			int l=  (-1*k);
			if(l>=arr.length)
				return l-2;
			return l-1;
		}
	}
	
	int findRow(int el,int[][] sortedMatrix) {
		int[] arr = getColArr(sortedMatrix, 0);
		int k = Arrays.binarySearch(arr, el);
		return getIndex(arr, k);
	}
	
	void printBinaryTree(Node root) {
		q.add(root);
		printTree(0);
	}
	
	void printTree(int level) {
		if(q.size()==0 && stack.size()==0)
			return;
		
		if(level%2==0) {
			while(!q.isEmpty()) {
				Node node = q.remove(0);
				System.out.println(node.val);
				if(node.left!=null)
					stack.push(node.left);
				if(node.right!=null)
					stack.push(node.right);
			}
		} else {
			Stack<Node> localSt = new Stack<>();
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				System.out.println(node.val);
				if(node.right!=null)
					localSt.push(node.right);
				if(node.left!=null)
					localSt.push(node.left);
			}
			while(!localSt.isEmpty()) {
				q.add(localSt.pop());
			}
		}
		
		printTree(level+1);
	}

	boolean anagramCheck(String s1,String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		Map<Character,Integer> freqMap = new HashMap<>();
		for(int i =0;i<s1.length();i++) {
			char c = s1.charAt(i);
			freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
		}
		
		for(int i =0;i<s1.length();i++) {
			char c = s2.charAt(i);
			if(!freqMap.containsKey(c)) {
				return false;
			} else {
				if(freqMap.get(c)-1==0) {
					freqMap.remove(c);
				} else {
					freqMap.put(c, freqMap.get(c)-1);
				}
			}
		}
		return freqMap.size()==0;
	}

	public static void main(String[] args) {
		MyClass m = new MyClass();
		int[][] matrix = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
		//System.out.println(m.findElement(matrix, 0));
		
		Node n = new Node(10);
		n.left = new Node(20);
		n.right = new Node(30);
		n.left.left = new Node(40);
		n.left.right = new Node(50);
		n.left.left.left = new Node(80);
		n.left.left.right = new Node(90);
		n.left.right.left = new Node(100);
		n.left.right.right = new Node(101);
		n.right.left = new Node(60);
		n.right.right = new Node(70);
		//m.printBinaryTree(n);
		
		String s1 = "ABC";
		String s2 = "CABA";
		System.out.println(m.anagramCheck(s1, s2));
	}
}

class Node {
	int val;
	Node left;
	Node right;

	Node(int v) {
		this.val = v;
	}
}



//promotion { float discount, applyPromotion(Item)
//Item {doule MRP, String name, abs GetPrice()}
//DiscountedItem( List<promotions> plist, getprice(
/*
*double price+= plist.applyPromotionl(this)
* */ 

//Cart { List<item> itemList , calclulateTotal() {
//	total+=item.getPrice()
//}}

//))
