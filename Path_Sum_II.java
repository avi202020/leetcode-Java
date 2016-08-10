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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    if (root == null) {
      return paths;
    }
    List<Integer> path = new ArrayList<Integer>();
    pathSumHelper(root, sum, path, paths);
    return paths;
  }
  public void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        List<Integer> newPath = new ArrayList<Integer>(path);
        newPath.add(root.val);
        paths.add(newPath);
      }
      return;
    }
    path.add(root.val);
    if (root.left != null) {
      pathSumHelper(root.left, sum - root.val, path, paths);
    }
    if (root.right != null) {
      pathSumHelper(root.right, sum - root.val, path, paths);
    }
    path.remove(path.size() - 1);
  }
}
