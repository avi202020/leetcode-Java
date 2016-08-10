/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<Integer> path = new ArrayList<Integer>();
    List<String> paths = new ArrayList<String>();
    if (root == null) {
      return paths;
    }
    binaryTreePathsHelper(root, path, paths);
    return paths;
  }
  public void binaryTreePathsHelper(TreeNode root, List<Integer> path, List<String> paths) {
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < path.size(); ++i) {
        sb.append(path.get(i));
        sb.append("->");
      }
      sb.append(root.val);
      paths.add(sb.toString());
    }
    path.add(root.val);
    if (root.left != null) {
      binaryTreePathsHelper(root.left, path, paths);
    }
    if (root.right != null) {
      binaryTreePathsHelper(root.right, path, paths);
    }
    path.remove(path.size() - 1);
  }
}
