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
	public ArrayList<Integer> inorderTraversal( TreeNode root ) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ans = new ArrayList<Integer>();
		inOrderCore( root, ans );
		return ans;
	}
	public void inOrderCore( TreeNode root, ArrayList<Integer> list )
	{
		if( root != null )
		{
			inOrderCore( root.left, list );
			list.add(root.val);
			inOrderCore( root.right, list );
		}
	}
}
