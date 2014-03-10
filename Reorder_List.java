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
    public void reorderList(ListNode head) {
        if( head == null || head.next == null )
            return;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode fast = head;
        ListNode slow = head;
        while( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        ListNode head2 = reverseList(slow);
        int count = 0;
        ListNode cur1 = head;
        ListNode cur2 = head2;
        while( cur1 != null && cur2 != null ) {
            if( count % 2 != 0 ) {
                prev.next = cur2;
                cur2 = cur2.next;
            } else {
                prev.next = cur1;
                cur1 = cur1.next;
            }
            count++;
            prev = prev.next;
        }
        if( cur1 != null )
            prev.next = cur1;
        else
            prev.next = cur2;
    }

    public ListNode reverseList(ListNode root) {
        if( root == null || root.next == null )
            return root;
        ListNode next = root.next;
        ListNode newHead = reverseList(root.next);
        next.next = root;
        root.next = null;
        return newHead;
    }
}
