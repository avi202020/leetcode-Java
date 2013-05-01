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
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if( root == null ) return ans;
		ArrayList<Integer> path = new ArrayList<Integer>();
		dfs( root, sum, path, ans );
		return ans;
	}
	public void dfs( TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans )
	{
		if( root.left == null && root.right == null )
		{
			if( sum == root.val )
			{
				path.add( root.val );
				ArrayList<Integer> newline = new ArrayList<Integer>(path);
				ans.add(newline);
				path.remove( path.size() - 1 );
			}
			return;
		}
		path.add(root.val);
		if( root.left != null )
			dfs( root.left, sum - root.val, path, ans );
		if( root.right != null )
			dfs( root.right, sum - root.val, path, ans );
		path.remove( path.size() - 1 );
	}
}
