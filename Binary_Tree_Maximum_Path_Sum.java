/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int maxsum;

	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		maxsum = Integer.MIN_VALUE;
		_maxPathSum(root);
		return maxsum;
	}

	public int _maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		int maxlocal = root.val;
		int maxleft = _maxPathSum(root.left);
		int maxright = _maxPathSum(root.right);
		if( maxleft > 0 ) maxlocal += maxleft;
		if( maxright > 0 ) maxlocal += maxright;
		if( maxlocal > maxsum ) maxsum = maxlocal;
		return Math.max( root.val, Math.max( root.val + maxleft, root.val + maxright) );
	}
}
