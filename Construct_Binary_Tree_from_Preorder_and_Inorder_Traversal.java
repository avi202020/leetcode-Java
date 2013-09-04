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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution belowr
		// DO NOT write main() function
		HashMap<Integer,Integer> posMap = new HashMap<Integer,Integer>();
		for( int i = 0; i < inorder.length; ++i )
			posMap.put(inorder[i], i);
		TreeNode root = _buildTree( preorder, 0, 0, preorder.length, posMap );
		return root;
	}

	public TreeNode _buildTree(int[] pre, int index, int start, int n, HashMap<Integer, Integer> posMap ) {
		if( n == 0 )
			return null;
		TreeNode root = new TreeNode( pre[index] );
		int length = posMap.get( pre[index] ) - start;
		root.left = _buildTree( pre, index + 1, start, length, posMap );
		root.right = _buildTree( pre, index + length + 1, start + length + 1, n - length - 1, posMap );
		return root;
	}
}
