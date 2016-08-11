/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1. BFS
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    List<TreeNode> queue = new ArrayList<TreeNode>();
    queue.add(root);
    int cur = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      int lastValue = 0;
      while (cur < end) {
        TreeNode node = queue.get(cur);
        lastValue = node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        cur++;
      }
      res.add(lastValue);
    }
    return res;
  }
}

// Solution 2. DFS
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    rightSideViewHelper(root, 0, res);
    return res;
  }
  public void rightSideViewHelper(TreeNode root, int depth, List<Integer> res) {
    if (root == null) {
      return;
    }
    if (depth >= res.size()) {
      res.add(root.val);
    }
    rightSideViewHelper(root.right, depth + 1, res);
    rightSideViewHelper(root.left, depth + 1, res);
  }
}
