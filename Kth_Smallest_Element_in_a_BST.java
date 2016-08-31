/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1. BST iterative inorder traversal
public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
    int i = 0;
    while (!stack.isEmpty()) {
      TreeNode t = stack.pop();
      i++;
      if (i == k) {
        return t.val;
      }
      TreeNode r = t.right;
      while (r != null) {
        stack.push(r);
        r = r.left;
      }
    }
    return -1;
  }
}

// Solution 2. using the number of children
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
