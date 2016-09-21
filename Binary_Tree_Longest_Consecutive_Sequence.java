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
  private int max = 0;
  public int longestConsecutive(TreeNode root) {
    if(root == null) {
      return max;
    }
    findLongestConsecutive(root, 0, root.val);
    return max;
  }

  private void findLongestConsecutive(TreeNode root, int cur, int target) {
    if (root == null) {
      return;
    }
    if (root.val == target) {
      cur++;
    } else {
      cur = 1;
    }
    max = Math.max(max, cur);
    findLongestConsecutive(root.left, cur, root.val + 1);
    findLongestConsecutive(root.right, cur, root.val + 1);
  }
}
