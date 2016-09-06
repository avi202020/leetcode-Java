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
    ListNode ans = l1.val < l2.val ? l1 : l2;
    ListNode pre = ans;
    if (l1.val < l2.val) l1 = l1.next;
    else l2 = l2.next;
    while (l1 != null || l2 != null) {
      int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
      int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
      pre.next = val1 < val2 ? l1 : l2;
      pre = pre.next;
      if (val1 < val2) l1 = l1 == null ? null : l1.next;
      else l2 = l2 == null ? null : l2.next;
    }
    return ans;
  }
}
