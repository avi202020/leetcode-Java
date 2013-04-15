/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//**************************************************************
//                    1.naive method
//**************************************************************
public class Solution {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( root == null ) 
			return true;
		int left = getHeight( root.left );
		int right = getHeight( root.right );
		if( Math.abs(left - right) > 1 )
			return false;
		boolean bleft = isBalanced( root.left );
		boolean bright = isBalanced( root.right );
		return bleft && bright;
	}
	public int getHeight( TreeNode root )
	{
		if( root == null )
			return 0;
		int left = getHeight( root.left );
		int right = getHeight( root.right );
		return Math.max( left , right ) + 1;
	}
}
