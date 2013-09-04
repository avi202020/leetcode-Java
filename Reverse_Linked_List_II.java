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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode pre = null;
		ListNode post = null;
		ListNode tail = null;
		int dist = 0;
		ListNode tmphead = new ListNode(0);
		tmphead.next = head;
		ListNode cur = tmphead;
		while( cur != null ) {
			if( dist == m - 1 )
				pre = cur;
			if( dist == n  )
				tail = cur;
			dist++;
			cur = cur.next;
		}
		post = tail.next;
		tail.next = null;
		ListNode newhead = _reverseLinklist( pre.next );
		pre.next = newhead;
		cur = newhead;
		while( cur.next != null )
			cur = cur.next;
		cur.next = post;
		return tmphead.next;
	}

	public ListNode _reverseLinklist(ListNode head) {
		if( head.next == null ) return head;
		ListNode next = head.next;
		ListNode newhead = _reverseLinklist( head.next );
		head.next = null;
		next.next = head;
		return newhead;
	}
}
