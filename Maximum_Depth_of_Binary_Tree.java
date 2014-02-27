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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if( root == null ) 
            return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max( lh, rh ) + 1 ;
    }
}
