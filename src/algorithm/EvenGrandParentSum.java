package algorithm;

import java.util.LinkedList;
import java.util.List;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

class EvenGrandParentSum {
    public int sumEvenGrandparent(TreeNode root) {
        List<TreeNode> l_even = new LinkedList<TreeNode>();
        List<TreeNode> l_odd = new LinkedList<TreeNode>();
        List list  = getList(root.val,l_even,l_odd);
        list.add(root.left);
        list.add(root.right);
        int sum = 0;
        TreeNode n = null;
        while(!l_even.isEmpty() || !l_odd.isEmpty()){
        		while(!l_even.isEmpty())
        		{
	        		n = l_even.remove(0);
	        		if(n==null) break;
	        		sum += (Integer)n.val;
	        		list = getList(n.val,l_even,l_odd);
	        		list.add(n.left);
	            list.add(n.right);
        		}
            
            while (!l_odd.isEmpty()) {
				n = l_odd.remove(0);
				if(n==null) break;
				list = getList(n.val, l_even, l_odd);
				list.add(n.left);
				list.add(n.right);
			}
        }
        return sum;
    }
    public List<TreeNode> getList(Integer value,List<TreeNode> l_even,List<TreeNode> l_odd){
    		return value%2==0 ? l_even :l_odd; 
    }
 
}