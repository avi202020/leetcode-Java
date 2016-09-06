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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode dumpHead = new ListNode(-1);
    ListNode pre = dumpHead;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        pre.next = l2;
        break;
      } else if (l2 == null) {
        pre.next = l1;
        break;
      }
      if (l1.val < l2.val) {
        pre.next = l1;
        pre = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        pre = l2;
        l2 = l2.next;
      }
    }
    return dumpHead.next;
  }
}
