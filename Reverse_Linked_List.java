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
  public ListNode reverseLinkedList( ListNode head ) {
   if( head == null ) return null;
   if( head.next == null ) return head;
   ListNode next = head.next;
   ListNode newhead = reverseLinkedList(next);
   head.next = null;
   next.next = head;
   return newhead;
 }
}
