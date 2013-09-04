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
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode listSmaller = new ListNode(0);
		ListNode listBigger = new ListNode(0);
		ListNode curSmaller = listSmaller;
		ListNode curBigger = listBigger;

		while( head != null ) {
			if( head.val < x ) {
				curSmaller.next = head;
				curSmaller = head;
			}
			else{
				curBigger.next = head;
				curBigger = head;
			}
			head = head.next;
		}
		curSmaller.next = listBigger.next;
		curBigger.next = null;
		return listSmaller.next;
	}
}
