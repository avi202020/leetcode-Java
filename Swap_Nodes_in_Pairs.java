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
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( head == null ) return null;
		if( head.next == null ) return head;
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while( cur != null )
		{
			if( cur.next == null ) return head;
			next = cur.next;
			if( pre == null )
				head = next;
			else if( pre != null )
				pre.next = next;
			cur.next = next.next;
			next.next = cur;
			pre = cur;
			cur = cur.next;
		}
		return head;
	}
}
