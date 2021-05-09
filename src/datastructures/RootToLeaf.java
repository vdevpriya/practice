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


class RootToLeaf {
	
long SUM = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root==null)
    		return (int)SUM;
        
        findRTL(root, -1);
        return (int)SUM;
    }
    
    private void findRTL(TreeNode node,int N) {
            if(node==null)
                return;
    		int z = N ==-1? 0: getNumOfZero(node.val);
    		int x = ((int)Math.pow(10, z) * (N==-1? 0: N)) + node.val;
            
    		if(node.left==null && node.right==null) {
    			SUM += x;
    			return;
    		} else {
    			findRTL(node.left, x);
    			findRTL(node.right, x);
    		}
    }
    
    static int getNumOfZero(int x) {
    		
    		int count = 0;
    		while(x>=10) {
    			x = x/10;
    			count++;
    		}
    		return count+1;
    }
}
