/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<TreeNode>();
    }
    List<TreeNode> ans = generateTreesHelper(1, n);
    return ans;
  }
  public List<TreeNode> generateTreesHelper(int start, int end) {
    List<TreeNode> ans = new ArrayList<TreeNode>();
    if (start > end) {
      ans.add(null);
      return ans;
    }
    for (int i = start; i <= end; ++i) {
      List<TreeNode> left = generateTreesHelper(start, i - 1);
      List<TreeNode> right = generateTreesHelper(i + 1, end);
      for (int j = 0; j < left.size(); ++j) {
        for (int k = 0; k < right.size(); ++k) {
          TreeNode node = new TreeNode(i);
          node.left = left.get(j);
          node.right = right.get(k);
          ans.add(node);
        }
      }
    }
    return ans;
  }
}
