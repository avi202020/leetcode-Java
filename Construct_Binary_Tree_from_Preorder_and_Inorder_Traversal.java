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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer,Integer> positions = new HashMap<Integer,Integer>();
    for (int i = 0; i < inorder.length; ++i) {
      positions.put(inorder[i], i);
    }
    TreeNode root = buildTreeHelper(preorder, 0, 0, preorder.length, positions);
    return root;
  }

  public TreeNode buildTreeHelper(int[] pre, int index, int start, int n, Map<Integer, Integer> posMap) {
    if (n == 0) {
      return null;
    }
    TreeNode root = new TreeNode(pre[index]);
    int length = posMap.get(pre[index]) - start;
    root.left = buildTreeHelper(pre, index + 1, start, length, posMap);
    root.right = buildTreeHelper(pre, index + length + 1, start + length + 1, n - length - 1, posMap);
    return root;
  }
}
