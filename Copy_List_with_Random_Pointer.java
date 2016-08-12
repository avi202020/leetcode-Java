/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// Solution No.1   O(n) time, O(n) space
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return head;
    }
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode dummy = new RandomListNode(-1);
    RandomListNode pre = dummy;
    RandomListNode cur = head;
    while (cur != null) {
      RandomListNode node = new RandomListNode(cur.label);
      pre.next = node;
      pre = node;
      map.put(cur, node);
      cur = cur.next;
    }
    RandomListNode p1 = head;
    RandomListNode p2 = dummy.next;
    while (p1 != null) {
      p2.random = map.get(p1.random);
      p1 = p1.next;
      p2 = p2.next;
    }
    return dummy.next;
  }
}

// Solution No.2   O(n) time, O(1) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null)
			return null;
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode node = new RandomListNode(cur.label);
			RandomListNode next_node = cur.next;
			cur.next = node;
			node.next = next_node;
			cur = next_node;
		}
		cur = head;
		while (cur != null) {
			RandomListNode next = cur.next;
			if( cur.random != null )
				next.random = cur.random.next;
			cur = next.next;
		}
		RandomListNode p1 = head;
		RandomListNode new_head = head.next;
		RandomListNode p2 = new_head;
		cur = new_head.next;
		int cnt = 0;
		while( cur != null ) {
			if( cnt % 2 == 0 )
			{
				p1.next = cur;
				p1 = cur;
			} else {
				p2.next = cur;
				p2 = cur;
			}
			cur = cur.next;
			cnt++;
		}
		p1.next = null;
		return new_head;
	}
}
