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
  private int sum;
  public int sumNumbers(TreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    sum = 0;
    _sumNumbers( root, 0 );
    return sum;
  }
  public void _sumNumbers( TreeNode root, int num )
  {
    if( root == null ) return;
    num = num * 10 + root.val;
    if( root.left == null && root.right == null )
      sum += num;
    _sumNumbers( root.left, num );
    _sumNumbers( root.right, num );
  }
}
