/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode pre = null;
    ListNode post = null;
    ListNode tail = null;
    int dist = 0;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur != null) {
      if (dist == m - 1) {
        pre = cur;
      }
      if (dist == n) {
        tail = cur;
      }
      dist++;
      cur = cur.next;
    }
    ListNode mthNode = pre.next;
    post = tail.next;
    tail.next = null;
    ListNode newhead = reverseBetweenHelper(pre.next);
    pre.next = newhead;
    mthNode.next = post;
    return dummy.next;
  }
  private ListNode reverseBetweenHelper(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    ListNode newHead = reverseBetweenHelper(head.next);
    next.next = head;
    head.next = null;
    return newHead;
  }
}
