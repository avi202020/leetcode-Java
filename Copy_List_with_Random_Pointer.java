/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if( head == null ) return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode old_head = new RandomListNode(-1);
		old_head.next = head;
		RandomListNode new_head = new RandomListNode(-1);
		RandomListNode p1 = old_head.next;
		RandomListNode p2 = new_head;
		while( p1 != null ) {
			RandomListNode node = new RandomListNode(p1.label);
			p2.next = node;
			p2 = node;
			map.put( p1, p2 );
			p1 = p1.next;
		}
		p1 = old_head.next;
		p2 = new_head.next;
		while( p2 != null ) {
			p2.random = map.get(p1.random);
			p2 = p2.next;
			p1 = p1.next;
		}
		return new_head.next;
	}
}
