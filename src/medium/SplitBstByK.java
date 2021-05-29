package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitBstByK {
	
	TreeNode[] splitBStByK(TreeNode root,int k) {
		Integer[] inorderArr = inorder(root);
		int kIndex = Arrays.binarySearch(inorderArr, k);
		TreeNode l = makeBalancedBST(inorderArr, 0, kIndex-1);
		TreeNode r = makeBalancedBST(inorderArr, kIndex, inorderArr.length-1);
		TreeNode[] split = new TreeNode[2];
		split[0] = l;
		split[1] = r;
		return split;
	}
	
	Integer[] inorder(TreeNode root) {
		List<Integer> l = getInorderTraversal(root);
		Integer[] inorderArr = (Integer[]) l.toArray();
		return inorderArr;
	}
	
	List getInorderTraversal(TreeNode root) {
		List<Integer> l = new LinkedList<Integer>();
		if(root.left==null && root.right==null) {
			l.add(root.val);
			return l;
		}
		if(root.left!=null) {
			l = getInorderTraversal(root.left);
		}
		l.add(root.val);
		if(root.right!=null) {
			l.addAll(getInorderTraversal(root.right));
		}
		return l;
	}
	
	TreeNode makeBalancedBST(Integer[] arr,int start,int end) {
		if(end==start) {
			return new TreeNode(arr[start]);
		}
		int mid = (end+start)/2;
		TreeNode rightBST = makeBalancedBST(arr, mid+1, end);
		TreeNode root = null;
		if(start==mid) {
			root = new TreeNode(arr[start]);
			root.right = rightBST;
			return root;
		} else {
			TreeNode leftBST = makeBalancedBST(arr, start, mid-1);
			root = new TreeNode(arr[mid]);
			root.left = leftBST;
			root.right = rightBST;
			return root;
		}
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v) {
		this.val = v;
	}
}
