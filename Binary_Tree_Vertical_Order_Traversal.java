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
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int minCol = 0;
    int maxCol = 0;
    List<TreeColumnNode> queue = new ArrayList<TreeColumnNode>();
    queue.add(new TreeColumnNode(root, 0));
    int cur = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      while (cur < end) {
        TreeColumnNode columnNode = queue.get(cur);
        int col = columnNode.column;
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        TreeNode node = columnNode.node;
        if (!map.containsKey(col)) {
          map.put(col, new ArrayList<Integer>());
        }
        map.get(col).add(node.val);
        if (node.left != null) {
          queue.add(new TreeColumnNode(node.left, col - 1));
        }
        if (node.right != null) {
          queue.add(new TreeColumnNode(node.right, col + 1));
        }
        cur++;
      }
    }
    for (int i = minCol; i <= maxCol; ++i) {
      res.add(map.get(i));
    }
    return res;
  }

  class TreeColumnNode {
    TreeNode node;
    int column;
    TreeColumnNode(TreeNode node, int col) {
      this.node = node;
      this.column = col;
    }
  }
}


// Solution 2. DFS it has one problem - left subtree will be visited first.
public class Solution {
  private int minCol;
  private int maxCol;
  public List<List<Integer>> verticalOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    minCol = 0;
    maxCol = 0;
    verticalOrderHelper(root, 0, map);
    for (int i = minCol; i <= maxCol; ++i) {
      res.add(map.get(i));
    }
    return res;
  }
  private void verticalOrderHelper(TreeNode root, int col, Map<Integer, List<Integer>> map) {
    if (root == null) {
      return;
    }
    minCol = Math.min(minCol, col);
    maxCol = Math.max(maxCol, col);
    if (!map.containsKey(col)) {
      map.put(col, new ArrayList<Integer>());
    }
    map.get(col).add(root.val);
    verticalOrderHelper(root.left, col - 1, map);
    verticalOrderHelper(root.right, col + 1, map);
  }
}
