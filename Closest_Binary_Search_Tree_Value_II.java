/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// solution 1.
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

// solution 2.
public class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    LinkedList<Integer> res = new LinkedList<>();
    inOrder(root, target, k, res);
    return res;
  }

  private void inOrder(TreeNode root, double target, int k, LinkedList<Integer> res) {
    if (root == null) {
      return;
    }
    inOrder(root.left, target, k, res);
    if (res.size() == k) {
      if (Math.abs(res.getFirst() - target) >= Math.abs(root.val - target)) {
        res.removeFirst();
        res.addLast(root.val);
      } else {
        return;
      }
    } else {
      res.addLast(root.val);
    }
    inOrder(root.right, target, k, res);
  }
}
