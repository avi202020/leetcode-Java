public class Solution {
  public int rob(TreeNode root) {
    int[] values = robHelper(root);
    return Math.max(values[0], values[1]);
  }
  public int[] robHelper(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int[] left = robHelper(root.left);
    int[] right = robHelper(root.right);
    int[] res = new int[2];
    // will not steal root house
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // steal root house
    res[1] = left[0] + right[0] + root.val;
    return res;
  }
}
