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
	static int sum;
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		sum = 0;
		dfs( root, 0 );
		return sum;
	}
	public void dfs( TreeNode root, int num )
	{
		if( root == null ) return;
		num = num * 10 + root.val;
		if( root.left == null && root.right == null )
			sum += num;
		dfs( root.left, num );
		dfs( root.right, num );
	}
}
