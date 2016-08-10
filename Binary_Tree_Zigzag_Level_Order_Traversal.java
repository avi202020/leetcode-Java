/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//********************************************************************************
//                             1. iterative method
//********************************************************************************
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }
    List<TreeNode> queue = new ArrayList<TreeNode>();
    queue.add(root);
    int cur = 0;
    int levelIndex = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      List<Integer> level = new ArrayList<>();
      while (cur < end) {
        TreeNode node = queue.get(cur);
        if (levelIndex % 2 == 0) {
          level.add(node.val);
        } else {
          level.add(0, node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        cur++;
      }
      res.add(level);
      levelIndex++;
    }
    return res;
  }
}


//********************************************************************************
//                            2. recursive method
//********************************************************************************
public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    zigzagLevelOrderHelper(root, 0, ans);
    return ans;
  }
  public void zigzagLevelOrderHelper(TreeNode root, int depth, List<List<Integer>> ans) {
    if (root == null) {
      return;
    }
    if (depth >= ans.size()) {
      ans.add(new ArrayList<Integer>());
    }
    List<Integer> level = ans.get(depth);
    if (depth % 2 == 0) {
      level.add(root.val);
    } else {
      level.add(0, root.val);
    }
    zigzagLevelOrderHelper(root.left, depth + 1, ans);
    zigzagLevelOrderHelper(root.right, depth + 1, ans);
  }
}
