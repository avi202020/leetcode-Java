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
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( head == null ) return head;
		ListNode cur = head;
		int len = 0;
		while( cur != null )
		{
			len++;
			cur = cur.next;
		}
		n = n % len;
		if( n == 0 ) return head;
		ListNode tmphead = new ListNode(0);
		tmphead.next = head;
		ListNode slowp = tmphead;
		ListNode fastp = head;
		int cnt = 1;
		while( fastp.next != null )
		{
			if( cnt != n ) cnt++;
			else slowp = slowp.next;
			fastp = fastp.next;
		}
		tmphead = slowp.next;
		fastp.next = head;
		slowp.next = null;
		return tmphead;
	}
}
