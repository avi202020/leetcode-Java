/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// solution 1.
public class Solution {
  public boolean isValidBST(TreeNode root) {
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    return isValidBSTHelper(root, min, max);
  }
  public boolean isValidBSTHelper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }
    return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
  }
}

// solution 2.
public class Solution {
  TreeNode pre = null;
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }
    if (pre != null && pre.val >= root.val) {
      return false;
    }
    pre = root;
    return isValidBST(root.right);
  }
}
