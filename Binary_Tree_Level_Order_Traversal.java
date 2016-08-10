/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//********************************************************
//                  1. iterative method
//********************************************************
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }
    List<TreeNode> queue = new ArrayList<TreeNode>();
    queue.add(root);
    int cur = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      List<Integer> level = new ArrayList<Integer>();
      while (cur < end) {
        TreeNode node = queue.get(cur);
        level.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        cur++;
      }
      res.add(level);
    }
    return res;
  }
}

//********************************************************
//                  2. recursive method
//********************************************************
public class Solution {
  public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    levelOrderCore(root, 0, ans);
    return ans;
  }
  public void levelOrderCore(TreeNode root, int depth, List<List<Integer>> ans) {
    if (root == null) {
      return;
    }
    List<Integer> level = null;
    if (depth >= ans.size()) {
      level = new ArrayList<Integer>();
      ans.add(level);
    } else {
      level = ans.get(depth);
    }
    level.add(root.val);
    levelOrderCore(root.left, depth + 1, ans);
    levelOrderCore(root.right, depth + 1, ans);
  }
}
