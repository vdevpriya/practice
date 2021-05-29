package datastructures;
 
class NumOfNodes {
    public int countNodes(TreeNode root) {
        if(root!=null)
        		return 1 + countNodes(root.left) + countNodes(root.right);
        
        return 0;
    }
}
