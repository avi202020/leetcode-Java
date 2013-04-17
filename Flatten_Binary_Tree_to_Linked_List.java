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
	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( root == null ) return;
		TreeNode right_tree = root.right;
		TreeNode left_tree = root.left;
		flatten( left_tree );
		flatten( right_tree );
		TreeNode tail = root;
		root.left = null;
		root.right = left_tree;
		while( tail.right != null )
			tail = tail.right;
		tail.right = right_tree;
	}
}
