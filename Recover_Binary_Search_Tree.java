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
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		convert2array( root, nodes, values );
		if( nodes.size() <= 1 ) 
			return;
		Collections.sort(values);
		for( int i = 0; i < nodes.size(); ++i )
			nodes.get(i).val = values.get(i);
		return;
	}
	public void convert2array( TreeNode root, ArrayList<TreeNode> nodes, ArrayList<Integer> values ) {
		if( root == null ) return;
		convert2array( root.left, nodes, values );
		nodes.add( root );
		values.add( root.val );
		convert2array( root.right, nodes, values );
	}
}


// Solution 2. O(1) space complexity
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

	TreeNode pre;
	TreeNode swap1;
	TreeNode swap2;

	public void recoverTree(TreeNode root) {
		if( root == null ) return;
		ArrayList<TreeNode> swaps = new ArrayList<TreeNode>();

		pre = null;
		swap1 = null;
		swap2 = null;
		dfs( root );
		int tmp = swap1.val;
		swap1.val = swap2.val;
		swap2.val = tmp;
		return;
	}
	public void dfs( TreeNode root ) {
		if( root == null ) return;
		dfs( root.left );
		if( pre != null && root.val < pre.val ) {
			swap2 = root;
			if( swap1 == null )
				swap1 = pre;
		}
		pre = root;
		dfs( root.right);
	}
}
