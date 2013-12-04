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

//////////////////////////////////////////////////////////////
//             naive solution using hashmap
/////////////////////////////////////////////////////////////
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( head == null ) 
			return head;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ListNode cur = head;
		while( cur != null ) {
			if( map.containsKey(cur.val) )
				map.put( cur.val, map.get(cur.val) + 1 );
			else
				map.put( cur.val, 1 );
			cur = cur.next;
		}
		ListNode newhead = null;
		ListNode pre = null;
		cur = head;
		while( cur != null ) {
			if( map.get(cur.val) > 1 ) {
				cur = cur.next;
				continue;
			}
			if( newhead == null ) {
				newhead = cur;
			}
			else {
				pre.next = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		if( pre != null )
			pre.next = null;
		return newhead;
	}
}



// Solution 2. two pointers
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
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null || head.next == null )
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while( pre.next != null ) {
            cur = pre.next;
            while( cur.next != null && cur.next.val == cur.val )
                cur = cur.next;
            if( pre.next != cur )
                pre.next = cur.next;
            else
                pre = cur;
        }
        
        return dummyHead.next;
    }
}
