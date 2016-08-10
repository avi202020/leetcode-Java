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
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode leftChild = root.left;
    TreeNode rightChild = root.right;
    flatten(leftChild);
    flatten(rightChild);
    root.left = null;
    root.right = leftChild;
    TreeNode tail = root;
    while (tail.right != null) {
      tail = tail.right;
    }
    tail.right = rightChild;
  }
}
