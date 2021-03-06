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


// Solution 2
public class Solution {
  public void flatten(TreeNode root) {
    TreeNode head = new TreeNode(-1);
    head.right = root;
    TreeNode node = head;

    while (node.right != null) {
      node = node.right;
      if (node.left != null) {
        TreeNode end = node.left;
        while (end.right != null) {
          end = end.right;
        }

        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = null;
        end.right = tmp;
      }
    }

    head.right = null;
  }
}
