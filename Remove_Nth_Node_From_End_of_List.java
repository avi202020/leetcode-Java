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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode pre = null;
		ListNode p1 = head;
		ListNode p2 = head;
		int cnt = 0;
		while( p1.next != null ) {
			p1 = p1.next;
			cnt++;
			if( cnt >= n ) {
				pre = p2;
				p2 = p2.next;
			}

		}
		if( pre != null )
			pre.next = p2.next;
		else 
			head = head.next;
		return head;
	}
}
