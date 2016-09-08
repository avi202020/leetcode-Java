tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    fast = slow.next;
    slow.next = null;
    ListNode head2 = reverseListHelper(fast);
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    int count = 0;
    ListNode cur1 = head;
    ListNode cur2 = head2;
    while (cur1 != null && cur2 != null) {
      if (count % 2 == 0) {
        prev.next = cur1;
        cur1 = cur1.next;
      } else {
        prev.next = cur2;
        cur2 = cur2.next;
      }
      prev = prev.next;
      count++;
    }
    if (cur1 != null) {
      prev.next = cur1;
    } else {
      prev.next = cur2;
    }
  }
  private ListNode reverseListHelper(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
