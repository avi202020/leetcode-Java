/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null )
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        fast = sortList(head);
        slow = sortList(slow);
        return merge(fast,slow);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if( head1 == null ) return head2;
        if( head2 == null ) return head1;
        ListNode res = null;
        ListNode pre = null;
        if( head1.val < head2.val ) {
            res = head1;
            head1 = head1.next;
        } else {
            res = head2;
            head2 = head2.next;
        }
        pre = res;
        while( head1 != null && head2 != null ) {
            if( head1.val < head2.val ) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if( head1 != null )
            pre.next = head1;
        else
            pre.next = head2;
        return res;
    }
}
