/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    fast = slow.next;
    slow.next = null;
    slow = sortList(head);
    fast = sortList(fast);
    return merge(slow, fast);
  }
  private ListNode merge(ListNode p1, ListNode p2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        pre.next = p1;
        p1 = p1.next;
      } else {
        pre.next = p2;
        p2 = p2.next;
      }
      pre = pre.next;
    }
    if (p1 != null) {
      pre.next = p1;
    } else if (p2 != null) {
      pre.next = p2;
    }
    return dummy.next;
  }
}
