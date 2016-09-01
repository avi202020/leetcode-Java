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
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode leftSubtree = upsideDownBinaryTree(root.left);
    TreeNode rightSubtree = upsideDownBinaryTree(root.right);
    if (leftSubtree == null) {
      return root;
    }
    root.left = null;
    root.right = null;
    TreeNode rightmost = leftSubtree;
    while (rightmost.right != null) {
      rightmost = rightmost.right;
    }
    rightmost.left = rightSubtree;
    rightmost.right = root;
    return leftSubtree;
  }
}
