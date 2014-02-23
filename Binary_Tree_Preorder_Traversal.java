/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// Solution 1. Naive and trivial solution using recursion, O(n) time, O(logn)
// space
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        inOrderCore(root, ans);
        return ans;
    }

    public void inOrderCore(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            inOrderCore(root.left, list);
            inOrderCore(root.right, list);
        }
    }
}

// Solution 2. Morris traversal algorithm, O(n) time, O(1) space
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        morrisPreorder(root, ans);
        return ans;
    }

    public void morrisPreorder(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else if (cur.left != null) {
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = cur;
                    ans.add(cur.val);
                    cur = cur.left;
                } else if (prev.right == cur) {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}
