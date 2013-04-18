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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode pre = null;
		ListNode head = null;
		int carry = 0;
		while( l1 != null || l2 != null || carry != 0 )
		{
			int value_l1 = ( l1 == null ? 0 : l1.val );
			int value_l2 = ( l2 == null ? 0 : l2.val );
			int sum = value_l1 + value_l2 + carry;
			ListNode cur = new ListNode( sum % 10 );
			if( head == null )
				head = cur;
			else if( head != null )
				pre.next = cur;
			pre = cur;
			carry = sum / 10;
			l1 = ( l1 == null ? l1 : l1.next );
			l2 = ( l2 == null ? l2 : l2.next );
		}
		return head;
	}
}
