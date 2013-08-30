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
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.isEmpty())
			return null;
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val < n2.val)
					return -1;
				else if (n1.val > n2.val)
					return 1;
				else
					return 0;
			}
		};
		ListNode head = null;
		ListNode pre = null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>( lists.size(), comparator );
		for (int i = 0; i < lists.size(); ++i) {
			if( lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}
		while (!heap.isEmpty()) {
			if( head == null ) {
				head = heap.poll();
				pre = head;
				if( head.next != null ) {
					heap.add(head.next);
				}
			}
			else {
				ListNode node = heap.poll();
				pre.next = node;
				pre = node;
				if( node.next != null ) {
					heap.add(node.next);
				}
			}
		}
		return head;
	}
}
