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
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		return isValidBST( root, min, max );
	}
	public boolean isValidBST( TreeNode root, int min, int max )
	{
		if( root == null ) return true;
		if( root.val <= min || root.val >= max )
			return false;
		boolean bleft = isValidBST( root.left, min, root.val );
		boolean bright = isValidBST( root.right, root.val, max );
		return bleft && bright;
	}
}
