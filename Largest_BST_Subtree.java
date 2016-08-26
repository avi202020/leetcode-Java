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
  private int maxSubtreeSize;
  public int largestBSTSubtree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    maxSubtreeSize = 0;
    largestBSTSubtreeHelper(root);
    return maxSubtreeSize;
  }
  // result format []
  private int[] largestBSTSubtreeHelper(TreeNode root) {
    if (root == null) {
      return new int[]{0, 1, Integer.MAX_VALUE, Integer.MIN_VALUE};
    }
    int[] left = largestBSTSubtreeHelper(root.left);
    int[] right = largestBSTSubtreeHelper(root.right);
    if (left[1] == 1 && right[1] == 1 && root.val < right[2] && root.val > left[3]) {
      int number = left[0] + right[0] + 1;
      maxSubtreeSize = Math.max(maxSubtreeSize, number);
      int minValue = Math.min(root.val, left[2]);
      int maxValue = Math.max(root.val, right[3]);
      return new int[]{number, 1, minValue, maxValue};
    } else {
      return new int[]{0, 0, 0, 0};
    }
  }
}
