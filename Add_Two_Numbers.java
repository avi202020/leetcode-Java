/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
      }
      if (l2 != null) {
        sum += l2.val;
      }
      ListNode node = new ListNode(sum % 10);
      pre.next = node;
      pre = node;
      carry = sum / 10;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}

