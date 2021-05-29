package easy;




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
 

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return createHeightBalBST(nums, 0, nums.length-1);
    }
	
	TreeNode createHeightBalBST(int[] nums,int start,int end) {
		if(start>end)
			return null;
		if(start==end) {
			return new TreeNode(nums[start]);
		}
		int mid = (start+end) /2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createHeightBalBST(nums, start, mid-1);
		root.right = createHeightBalBST(nums, mid+1, end);
		return root;
	}
}
