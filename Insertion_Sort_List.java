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
    public ListNode insertionSortList(ListNode head) {
        if( head == null || head.next == null )
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while( cur != null ) {
            ListNode next = cur.next;
            ListNode prev = findPosition(dummy, cur);
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode findPosition(ListNode dummy, ListNode node ) {
        ListNode cur = dummy;
        while( cur.next != null && cur.next.val <= node.val ) {
            cur = cur.next;
        }
        return cur;
    }
}
