/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    while (head != null) {
      if (head.val != val) {
        pre.next = head;
        pre = head;
      }
      head = head.next;
    }
    pre.next = null;
    return dummy.next;
  }
}
