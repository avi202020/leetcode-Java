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
