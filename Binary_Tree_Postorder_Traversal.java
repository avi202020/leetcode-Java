/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// Solution 1. Naive and trivial solution using recursion, O(n) time, O(logn) space
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postorder = new ArrayList<Integer>();
    postorderTraversalHelper(root, postorder);
    return postorder;
  }
  public void postorderTraversalHelper(TreeNode root, List<Integer> postorder) {
    if (root != null) {
      postorderTraversalHelper(root.left, postorder);
      postorderTraversalHelper(root.right, postorder);
      postorder.add(root.val);
    }
  }
}

// Solution 2. Morris traversal algorithm, O(n) time, O(1) space
public class Solution {
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    morrisPostorder(root, ans);
    return ans;
  }

  public void morrisPostorder(TreeNode root, ArrayList<Integer> ans) {
    if (root == null)
      return;
    TreeNode dummy = new TreeNode(-1);
    dummy.left = root;
    TreeNode cur = dummy;
    TreeNode prev = null;
    while (cur != null) {
      if (cur.left == null) {
        // bacause it is postorder, we don't visit cur at this moment.
        // we have to traverse the right subtree first.
        cur = cur.right;
      } else {
        prev = cur.left;
        while (prev.right != null && prev.right != cur)
          prev = prev.right;
        // the left subtree has not been visited, goto left subtree
        if (prev.right == null) {
          prev.right = cur;
          cur = cur.left;
        }
        // the left subtree has been visited, print all root nodes of left subtree
        else if (prev.right == cur) {
          printReverse(cur.left, prev, ans);
          prev.right = null;
          cur = cur.right;
        }
      }
    }
  }
}
