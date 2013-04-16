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
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return buildBST( num, 0, num.length - 1 );
	}
	public TreeNode buildBST( int num[], int low, int hi )
	{
		if( low > hi ) return null;
		int mid = ( low + hi ) / 2;
		TreeNode node = new TreeNode( num[mid] );
		node.left = buildBST( num, low, mid - 1 );
		node.right = buildBST( num, mid + 1, hi );
		return node;
	}
}
