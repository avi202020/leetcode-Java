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
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    LinkedList<Integer> klist = new LinkedList<Integer>();
    Stack<TreeNode> stk = new Stack<TreeNode>();
    while (root != null) {
      stk.push(root);
      root = root.left;
    }
    while (!stk.isEmpty()) {
      TreeNode curr = stk.pop();
      if (klist.size() < k) {
        klist.offer(curr.val);
      } else {
        int first = klist.peek();
        if (Math.abs(first - target) > Math.abs(curr.val - target)) {
          klist.poll();
          klist.offer(curr.val);
        } else {
          break;
        }
      }
      if (curr.right != null) {
        curr = curr.right;
        while (curr != null) {
          stk.push(curr);
          curr = curr.left;
        }
      }
    }
    return klist;
  }
}
