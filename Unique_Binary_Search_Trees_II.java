/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> ans = _generateTrees( 1, n );
		return ans;
	}

	public ArrayList<TreeNode> _generateTrees( int start, int end ) {
		ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
		if( start > end ) {
			ans.add(null);
			return ans;
		}
		for( int i = start; i <= end; ++i ) {
			ArrayList<TreeNode> left = _generateTrees( start, i-1 );
			ArrayList<TreeNode> right = _generateTrees( i+1, end );
			for( int j = 0; j < left.size(); ++j ) {
				for( int k = 0; k < right.size(); ++k ) {
					TreeNode node = new TreeNode(i);
					node.left = left.get(j);
					node.right = right.get(k);
					ans.add(node);
				}
			}
		}
		return ans;
	}
}
