package datastructures;

// Definition for a binary tree node.
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
 
class NumOfNodes {
    public int countNodes(TreeNode root) {
        if(root!=null)
        		return 1 + countNodes(root.left) + countNodes(root.right);
        
        return 0;
    }
}
