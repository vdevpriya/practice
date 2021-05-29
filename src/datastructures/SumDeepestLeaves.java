package datastructures;


public class SumDeepestLeaves {
	
	int maxDepthSofar = 0;
	int sum = 0;
	public int deepestLeavesSum(TreeNode root) {
		traverseTree(root, 0);
		return sum;
	}
	private void traverseTree(TreeNode node, int depth)
	{
		if(node==null)
			return;
		if(node.left == null && node.right==null)
		{
			if(depth>maxDepthSofar)
			{
				maxDepthSofar = depth;
				sum = node.val;
			} else if(depth == maxDepthSofar)
			{
				sum += node.val;
			}
		}
		else {
			traverseTree(node.left, depth+1);
			traverseTree(node.right, depth+1);
		}
	}
}
