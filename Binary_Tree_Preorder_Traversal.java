/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// Solution 1. Naive solution using recursion, O(n) time, O(logn) space
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<Integer>();
    preorderTraversalHelper(root, preorder);
    return preorder;
  }
  public void preorderTraversalHelper(TreeNode root, List<Integer> preorder) {
    if (root != null) {
      preorder.add(root.val);
      preorderTraversalHelper(root.left, preorder);
      preorderTraversalHelper(root.right, preorder);
    }
  }
}

// Solution 2. Iterative solution using stack, O(n) time, O(logn) space
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<Integer>();
    if (root == null) {
      return preorder;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      preorder.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return preorder;
  }
}

// Solution 3. Morris traversal algorithm, O(n) time, O(1) space
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<Integer>();
    morrisPreorder(root, preorder);
    return preorder;
  }
  public void morrisPreorder(TreeNode root, List<Integer> preorder) {
    TreeNode cur = root;
    TreeNode pre = null;
    while (cur != null) {
      if (cur.left == null) {
        // if there is no left subtree, visit cur and go right
        preorder.add(cur.val);
        cur = cur.right;
      } else {
        pre = cur.left;
        while (pre.right != null && pre.right != cur) {
          pre = pre.right;
        }
        if (pre.right == null) {
          // cur's left subtree has not been visited, go left first
          preorder.add(cur.val);
          pre.right = cur;
          cur = cur.left;
        } else {
          // cur's left subtree has been visited, visit cur and go right
          pre.right = null;
          cur = cur.right;
        }
      }
    }
  }
}
