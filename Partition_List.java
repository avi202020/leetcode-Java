/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode dummyLess = new ListNode(-1);
    ListNode dummyGreater = new ListNode(-1);
    ListNode preLess = dummyLess;
    ListNode preGreater = dummyGreater;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        preLess.next = cur;
        preLess = cur;
      } else {
        preGreater.next = cur;
        preGreater = cur;
      }
      cur = cur.next;
    }
    preLess.next = dummyGreater.next;
    preGreater.next = null;
    return dummyLess.next;
  }
}
