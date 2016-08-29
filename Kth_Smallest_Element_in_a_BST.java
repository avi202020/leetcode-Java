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
  public int kthSmallest(TreeNode root, int k) {
    if (k == 1) {
      while (root.left != null) {
        root = root.left;
      }
      return root.val;
    }
    int leftNodes = getNodesCount(root.left);
    if (k == leftNodes + 1) {
      return root.val;
    } else if (k <= leftNodes) {
      return kthSmallest(root.left, k);
    } else {
      return kthSmallest(root.right, k - leftNodes - 1);
    }
  }
  private int getNodesCount(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getNodesCount(root.left);
    int right = getNodesCount(root.right);
    return left + right + 1;
  }
}
