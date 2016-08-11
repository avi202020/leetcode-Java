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
  private int sum;
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    sum = 0;
    sumNumbersHelper(root, 0);
    return sum;
  }
  public void sumNumbersHelper(TreeNode root, int num) {
    if (root == null) {
      return;
    }
    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += num;
    }
    sumNumbersHelper(root.left, num);
    sumNumbersHelper(root.right, num);
  }
}
