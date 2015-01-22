/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/*
*/
public class Solution {
  public void connect(TreeLinkNode root) {
    if( root == null )
      return;
    TreeLinkNode parent = root;
    TreeLinkNode next = parent.left;
    while( parent != null && next != null ) {
      TreeLinkNode prev = null;
      while( parent != null ) {
        if( prev == null ) {
          prev = parent.left;
        } else {
          prev.next = parent.left;
          prev = prev.next;
        }
        prev.next = parent.right;
        prev = prev.next;
        parent = parent.next;
      }
      parent = next;
      next = parent.left;
    }
  }
}

public class Solution {
  public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
    if( root == null ) return;
    queue.add(root);
    int cur = 0;
    while( cur < queue.size() ) {
      int end = queue.size();
      int head = cur;
      while( cur < end ) {
        if( queue.get(cur).left != null )
          queue.add( queue.get(cur).left );
        if( queue.get(cur).right != null )
          queue.add( queue.get(cur).right );
        cur++;
      }
      for( int i = head; i < end - 1; ++i )
        queue.get(i).next = queue.get(i+1);
      queue.get(cur-1).next = null;
    }
  }
}
