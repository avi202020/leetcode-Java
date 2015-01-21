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
    if( headA == null || headB == null )
      return null;
    int lenA = 1;
    ListNode pa = headA;
    while( pa.next != null ) {
      lenA++;
      pa = pa.next;
    }
    int lenB = 1;
    ListNode pb = headB;
    while( pb.next != null ) {
      lenB++;
      pb = pb.next;
    }
    if( pa != pb )
      return null;
    pa = headA;
    pb = headB;
    if( lenA < lenB  ) {
      int diff = lenB - lenA;
      while( diff > 0) {
        pb = pb.next;
        diff--;
      }
    }
    else if( lenA > lenB ) {
      int diff = lenA - lenB;
      while( diff > 0 ) {
        pa = pa.next;
        diff--;
      }
    }
    while( pa != pb ) {
      pa = pa.next;
      pb = pb.next;
    }
    return pa;
  }
}
