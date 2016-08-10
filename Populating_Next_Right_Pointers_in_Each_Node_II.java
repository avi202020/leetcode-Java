/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect2(TreeLinkNode root) {
    if( root == null )
      return;
    TreeLinkNode parent = root;
    while( parent != null ) {
      TreeLinkNode next = null;
      TreeLinkNode prev = null;
      while( parent != null ) {
        if( next == null )
          next = (parent.left != null) ? parent.left : parent.right;
        if( parent.left != null ) {
          if( prev == null ) {
            prev = parent.left;
          } else {
            prev.next = parent.left;
            prev = prev.next;
          }
        }
        if( parent.right != null ) {
          if( prev == null ) {
            prev = parent.right;
          } else {
            prev.next = parent.right;
            prev = prev.next;
          }
        }
        parent = parent.next;
      }
      parent = next;
    }
  }
}

public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    List<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
    queue.add(root);
    int cur = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      List<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
      while (cur < end) {
        TreeLinkNode node = queue.get(cur);
        level.add(node);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        cur++;
      }
      for (int i = 0; i < level.size() - 1; ++i) {
        level.get(i).next = level.get(i + 1);
      }
      level.get(level.size() - 1).next = null;
    }
  }
}
