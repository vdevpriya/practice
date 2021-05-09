package datastructures;


public class FindNode {
	 public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		 if(original==target)
			 return cloned;
		 if(original==null)
			 return null;
		 TreeNode t2 = null;
		 t2 = traverse(original.left, cloned.left, target);
		 if(t2==null)
			 t2 = traverse(original.right, cloned.right, target);
		 
		 return t2;
	    }
	 
	 private TreeNode traverse(TreeNode r1, TreeNode r2, TreeNode target)
	 {
		 if(r1==target)
			 return r2;
		 if(r1==null)
			 return null;
		 TreeNode t2 = null;
		 t2 = traverse(r1.left, r2.left, target);
		 if(t2==null)
			 t2 = traverse(r1.right, r2.right, target);
		 
		 return t2;
	 }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

