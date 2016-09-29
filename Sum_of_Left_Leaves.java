/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeavesHelper(root, false);
  }
  public int sumOfLeftLeavesHelper(TreeNode root, boolean left) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (left && root.left == null && root.right == null) {
      sum += root.val;
    }
    if (root.left != null) {
      sum += sumOfLeftLeavesHelper(root.left, true);
    }
    if (root.right != null) {
      sum += sumOfLeftLeavesHelper(root.right, false);
    }
    return sum;
  }
}
