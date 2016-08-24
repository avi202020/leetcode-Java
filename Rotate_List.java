/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    k = k % len;
    if (k == 0) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode newHead = slow.next;
    slow.next = null;
    fast.next = head;
    return newHead;
  }
}
