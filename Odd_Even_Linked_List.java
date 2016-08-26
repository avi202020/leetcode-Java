/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dummyOdd = new ListNode(-1);
    ListNode dummyEven = new ListNode(-1);
    ListNode preOdd = dummyOdd;
    ListNode preEven = dummyEven;
    ListNode cur = head;
    int count = 1;
    while (cur != null) {
      if (count % 2 == 1) {
        preOdd.next = cur;
        preOdd = cur;
      } else {
        preEven.next = cur;
        preEven = cur;
      }
      cur = cur.next;
      count++;
    }
    preEven.next = null;
    preOdd.next = dummyEven.next;
    return dummyOdd.next;
  }
}
