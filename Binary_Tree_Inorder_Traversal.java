/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// Solution 1. Naive solution using recursion, O(n) time, O(logn) space
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<Integer>();
    inorderTraversalHelper(root, inorder);
    return inorder;
  }
  public void inorderTraversalHelper(TreeNode root, List<Integer> inorder) {
    if (root != null) {
      inorderTraversalHelper(root.left, inorder);
      inorder.add(root.val);
      inorderTraversalHelper(root.right, inorder);
    }
  }
}

// Solution 2. Iterative solution using stack, O(n) time, O(logn) space
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<Integer>();
    if (root == null) {
      return inorder;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      inorder.add(cur.val);
      cur = cur.right;
    }
    return inorder;
  }
}

// Solution 3. Morris traversal algorithm, O(n) time, O(1) space
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<Integer>();
    morrisInorder(root, inorder);
    return inorder;
  }
  public void morrisInorder(TreeNode root, List<Integer> inorder) {
    TreeNode cur = root;
    TreeNode prev = null;
    while (cur != null) {
      if (cur.left == null) {
        // if there is no left subtree, visit cur and go right
        inorder.add(cur.val);
        cur = cur.right;
      } else {
        // find cur's previous node in in-order
        prev = cur.left;
        while (prev.right != null && prev.right != cur) {
          prev = prev.right;
        }
        if (prev.right == null) {
          // this node has not been visited, go left first
          prev.right = cur;
          cur = cur.left;
        } else {
          // this node has been visited, visit cur and go right
          prev.right = null;
          inorder.add(cur.val);
          cur = cur.right;
        }
      }
    }
  }
}
