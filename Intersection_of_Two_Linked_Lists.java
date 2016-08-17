/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int lengthA = 1;
    ListNode pa = headA;
    while (pa.next != null) {
      lengthA++;
      pa = pa.next;
    }
    int lengthB = 1;
    ListNode pb = headB;
    while (pb.next != null) {
      lengthB++;
      pb = pb.next;
    }
    if (pa != pb) {
      return null;
    }
    pa = headA;
    pb = headB;
    int diff = Math.abs(lengthA - lengthB);
    if (lengthA < lengthB) {
      for (int i = 0; i < diff; ++i) {
        pb = pb.next;
      }
    } else if (lengthA > lengthB) {
      for (int i = 0; i < diff; ++i) {
        pa = pa.next;
      }
    }
    while (pa != pb) {
      pa = pa.next;
      pb = pb.next;
    }
    return pa;
  }
}
