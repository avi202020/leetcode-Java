/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1. find the middle node then 
public class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode fast = head;
    ListNode slow = head;
    ListNode pre = null;
    while (fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next;
      if (fast.next != null) {
        fast = fast.next;
      }
    }
    pre.next = null;
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
  }
}

// Solution 2.
public class Solution {
  private ListNode current;
  private int getListLength(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }

  public TreeNode sortedListToBST(ListNode head) {
    current = head;
    int size = getListLength(head);
    return sortedListToBSTHelper(size);
  }

  public TreeNode sortedListToBSTHelper(int size) {
    if (size <= 0) {
      return null;
    }

    TreeNode left = sortedListToBSTHelper(size / 2);
    TreeNode root = new TreeNode(current.val);
    current = current.next;
    TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

    root.left = left;
    root.right = right;
    return root;
  }
}
