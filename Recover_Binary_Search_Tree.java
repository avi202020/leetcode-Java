/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1. Naive solution using a ArrayList to store every node.
public class Solution {
  public void recoverTree(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<TreeNode>();
    List<Integer> values = new ArrayList<Integer>();
    convertToArray(root, nodes, values);
    if (nodes.size() < 1) {
      return;
    }
    Collections.sort(values);
    for( int i = 0; i < nodes.size(); ++i )
      nodes.get(i).val = values.get(i);
    return;
  }
  public void convertToArray(TreeNode root, List<TreeNode> nodes, List<Integer> values) {
    if (root == null) {
      return;
    }
    convertToArray(root.left, nodes, values);
    nodes.add(root);
    values.add(root.val);
    convertToArray(root.right, nodes, values);
  }
}


// Solution 2. O(1) space complexity
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
  private TreeNode lastNode = null;
  private TreeNode firstNode = null;
  private TreeNode secondNode = null;
  public void recoverTree(TreeNode root) {
    firstNode = null;
    secondNode = null;
    lastNode = new TreeNode(Integer.MIN_VALUE);
    recoverTreeHelper(root);
    int tmp = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = tmp;
  }
  public void recoverTreeHelper(TreeNode root) {
    if (root == null) {
      return;
    }
    recoverTreeHelper(root.left);
    if (firstNode == null && root.val < lastNode.val) {
      firstNode = lastNode;
    }
    if (firstNode != null && root.val < lastNode.val) {
      secondNode = root;
    }
    lastNode = root;
    recoverTreeHelper(root.right);
  }
}


